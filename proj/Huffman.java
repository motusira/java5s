import java.util.*;
import java.util.PriorityQueue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//узел дерева
class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}


public class Huffman {
    private final Map<Character, String> huffmanCodes = new HashMap<>();
    private final Map<Character, Integer> frequencyMap = new HashMap<>();
    private HuffmanNode root;

    //дерево
    public void buildHuffmanTree(String text) {
        huffmanCodes.clear();
        frequencyMap.clear();
        //считаем частоты
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        if (frequencyMap.size() == 1) {
            char singleChar = frequencyMap.keySet().iterator().next();
            root = new HuffmanNode(singleChar, frequencyMap.get(singleChar));
            huffmanCodes.put(singleChar, "0");
            return;
        }

        //приоритетная очередь
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        //строим дерево
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            assert right != null;
            HuffmanNode parent = new HuffmanNode('\0',
                    left.frequency + right.frequency, left, right);
            pq.add(parent);
        }

        root = pq.poll();
        generateCodes(root, "");
    }

    //генерим коды
    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) return;

        if (node.isLeaf()) {
            huffmanCodes.put(node.character, code);
        }

        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }

    //кодирование
    public String encode(String text) {
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            encoded.append(huffmanCodes.get(c));
        }
        return encoded.toString();
    }

    //декодирование
    public String decode(String encodedText) {
        //особый случай 1 символ
        if (root != null && root.isLeaf()) {
            char singleChar = root.character;
            StringBuilder decoded = new StringBuilder();
            for (int i = 0; i < encodedText.length(); i++) {
                decoded.append(singleChar);
            }
            return decoded.toString();
        }

        StringBuilder decoded = new StringBuilder();
        HuffmanNode current = root;

        for (char bit : encodedText.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.isLeaf()) {
                decoded.append(current.character);
                current = root;
            }
        }

        return decoded.toString();
    }

    //собираем все листовые узлы в список
    private void collectLeafNodes(HuffmanNode node, List<HuffmanNode> leafNodes) {
        if (node == null) {
            return;
        }

        if (node.isLeaf()) {
            leafNodes.add(node);
        } else {
            collectLeafNodes(node.left, leafNodes);
            collectLeafNodes(node.right, leafNodes);
        }
    }

    //вывод
    public void printHuffmanCodes() {
        System.out.println("Huffman Codes:");
        System.out.println("Char\tFrequency\tCode");
        System.out.println("--------------------------------");

        List<HuffmanNode> leafNodes = new ArrayList<>();
        collectLeafNodes(root, leafNodes);

        //сортируем по убыванию частоты и по алфавиту
        leafNodes.sort((a, b) -> {
            int freqCompare = Integer.compare(b.frequency, a.frequency);
            if (freqCompare != 0) {
                return freqCompare;
            }
            return Character.compare(a.character, b.character);
        });

        for (HuffmanNode node : leafNodes) {
            String displayChar = getDisplayChar(node.character);
            String code = huffmanCodes.get(node.character);

            System.out.printf("%-6s\t%-10d\t%s%n", displayChar, node.frequency, code);
        }
    }

    public String getDisplayChar(char c){
        String displayChar;
        if (c == '\n') displayChar = "\\n";
        else if (c == '\t') displayChar = "\\t";
        else if (c == '\r') displayChar = "\\r";
        else if (c == ' ') displayChar = "space";
        else displayChar = String.valueOf(c);
        return displayChar;
    }

    public void printTree() {
        System.out.println("Huffman Tree Structure:");
        System.out.println("==========================================");
        printTree(root, 0, "", true);
        System.out.println("==========================================");
    }

    private void printTree(HuffmanNode node, int level, String prefix, boolean isTail) {
        if (node == null) return;

        String connector = level == 0 ? "Root: " : isTail ? "└── " : "├── ";
        System.out.println(prefix + connector + getNodeLabel(node));

        String newPrefix = prefix + (isTail ? "    " : "│   ");

        if (node.left != null || node.right != null) {
            if (node.left != null) {
                printTree(node.left, level + 1, newPrefix, node.right == null);
            }
            if (node.right != null) {
                printTree(node.right, level + 1, newPrefix, true);
            }
        }
    }

    private String getNodeLabel(HuffmanNode node) {
        if (node.isLeaf()) {
            String charDisplay = getDisplayChar(node.character);
            return "[" + charDisplay + ": " + node.frequency + "]";
        } else {
            return "Node(" + node.frequency + ")";
        }
    }

    public void compareWithASCII(String originalText) {
        int originalSize = originalText.length() * 8; //8 бит на символ аскии
        String encodedText = encode(originalText);
        int huffmanSize = encodedText.length();

        double compressionRatio = (1 - (double)huffmanSize / originalSize) * 100;

        System.out.println("\nComparison with ASCII:");
        System.out.println("Original text size (ASCII): " + originalSize + " bits");
        System.out.println("Huffman encoded size: " + huffmanSize + " bits");
        System.out.printf("Compression ratio: %.2f%%%n", compressionRatio);
        System.out.println("Space saved: " + (originalSize - huffmanSize) + " bits");
    }

    public void compareWithASCIIFile(String inputFile, String compressedFile) throws IOException {
        String originalText = new String(Files.readAllBytes(Paths.get(inputFile)));
        int originalSize = originalText.length() * 8; // 8 бит на символ ASCII

        byte[] compressedBytes = Files.readAllBytes(Paths.get(compressedFile));
        int compressedSize = compressedBytes.length * 8;

        double compressionRatio = (1 - (double)compressedSize / originalSize) * 100;

        System.out.println("\nFile Comparison with ASCII:");
        System.out.println("Original file size (ASCII): " + originalSize + " bits (" +
                (originalSize / 8) + " bytes)");
        System.out.println("Compressed file size: " + compressedSize + " bits (" +
                compressedBytes.length + " bytes)");
        System.out.printf("Compression ratio: %.2f%%%n", compressionRatio);
        System.out.println("Space saved: " + (originalSize - compressedSize) + " bits (" +
                ((originalSize - compressedSize) / 8) + " bytes)");
    }

    public void compressFile(String inputFile, String outputFile) throws IOException {
        // читаем текст
        String text = new String(Files.readAllBytes(Paths.get(inputFile)));

        // строим дерево
        buildHuffmanTree(text);

        // кодируем
        String encoded = encode(text);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            // сохраняем частоты (чтобы восстановить дерево)
            oos.writeObject(frequencyMap);

            // сохраняем длину битовой строки
            oos.writeInt(encoded.length());

            // сохраняем сжатые данные (как байты)
            byte[] compressed = toByteArray(encoded);
            oos.write(compressed);
        }
    }

    public void decompressFile(String inputFile, String outputFile) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            Map<Character, Integer> freq = (Map<Character, Integer>) ois.readObject();
            this.frequencyMap.clear();
            this.frequencyMap.putAll(freq);

            // особый случай один символ
            if (freq.size() == 1) {
                char singleChar = freq.keySet().iterator().next();
                root = new HuffmanNode(singleChar, freq.get(singleChar));
                huffmanCodes.put(singleChar, "0");
            } else {
                // обычный случай
                PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
                for (Map.Entry<Character, Integer> e : freq.entrySet()) {
                    pq.add(new HuffmanNode(e.getKey(), e.getValue()));
                }
                while (pq.size() > 1) {
                    HuffmanNode left = pq.poll();
                    HuffmanNode right = pq.poll();
                    pq.add(new HuffmanNode('\0', left.frequency + right.frequency, left, right));
                }
                root = pq.poll();
                generateCodes(root, "");
            }

            // количество битов
            int bitLength = ois.readInt();

            // оставшиеся байты
            byte[] compressed = ois.readAllBytes();

            // восстанавливаем битовую строку с точной длиной
            String encoded = fromByteArray(compressed, bitLength);
            String decoded = decode(encoded);

            Files.write(Paths.get(outputFile), decoded.getBytes());
        }
    }

    // побитовая упаковка строки "010101..."
    private byte[] toByteArray(String bits) {
        int byteLength = (bits.length() + 7) / 8;
        byte[] result = new byte[byteLength];
        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '1') {
                result[i / 8] |= 1 << (7 - (i % 8));
            }
        }
        return result;
    }

    private String fromByteArray(byte[] bytes, int bitLength) {
        StringBuilder sb = new StringBuilder();
        int bitsProcessed = 0;

        for (byte b : bytes) {
            for (int i = 7; i >= 0; i--) {
                if (bitsProcessed < bitLength) {
                    sb.append((b >> i) & 1);
                    bitsProcessed++;
                } else {
                    break;
                }
            }
            if (bitsProcessed >= bitLength) break;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Huffman huffman = new Huffman();

        System.out.println("Huffman Coding Algorithm");
        System.out.println("=========================");
        System.out.println(System.getProperty("user.dir"));

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Encode text");
            System.out.println("2. Decode text");
            System.out.println("3. Show Huffman codes");
            System.out.println("4. Show Huffman tree");
            System.out.println("5. Compare with ASCII (text)");
            System.out.println("6. Exit");
            System.out.println("7. Compress file");
            System.out.println("8. Decompress file");
            System.out.println("9. Compare with ASCII (file)");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text to encode: ");
                    String textToEncode = scanner.nextLine();

                    huffman.buildHuffmanTree(textToEncode);
                    String encoded = huffman.encode(textToEncode);

                    System.out.println("Encoded text: " + encoded);
                    break;

                case 2:
                    System.out.print("Enter encoded binary string: ");
                    String textToDecode = scanner.nextLine();

                    try {
                        String decoded = huffman.decode(textToDecode);
                        System.out.println("Decoded text: " + decoded);
                    } catch (Exception e) {
                        System.out.println("Error decoding: " + e.getMessage());
                    }
                    break;

                case 3:
                    huffman.printHuffmanCodes();
                    break;

                case 4:
                    huffman.printTree();
                    break;

                case 5:
                    System.out.print("Enter text for comparison: ");
                    String textForComparison = scanner.nextLine();
                    huffman.buildHuffmanTree(textForComparison);
                    huffman.compareWithASCII(textForComparison);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                case 7:
                    System.out.print("Enter input text file path: ");
                    String inputFile = scanner.nextLine();
                    System.out.print("Enter output compressed file path: ");
                    String compressedFile = scanner.nextLine();
                    try {
                        huffman.compressFile(inputFile, compressedFile);
                        System.out.println("File compressed successfully: " + compressedFile);
                    } catch (Exception e) {
                        System.out.println("Error compressing file: " + e.getMessage());
                    }
                    break;

                case 8:
                    System.out.print("Enter input compressed file path: ");
                    String compressedInput = scanner.nextLine();
                    System.out.print("Enter output text file path: ");
                    String outputFile = scanner.nextLine();
                    try {
                        huffman.decompressFile(compressedInput, outputFile);
                        System.out.println("File decompressed successfully: " + outputFile);
                    } catch (Exception e) {
                        System.out.println("Error decompressing file: " + e.getMessage());
                    }
                    break;

                case 9:
                    System.out.print("Enter original txt-file path: ");
                    String inputCompFile = scanner.nextLine();
                    System.out.print("Enter compressed bin-file path: ");
                    String outputBinFile = scanner.nextLine();

                    try {
                        huffman.compareWithASCIIFile(inputCompFile, outputBinFile);
                    } catch (Exception e) {
                        System.out.println("Error comparing files: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}


