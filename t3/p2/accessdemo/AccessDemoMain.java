import accessdemo.ParentClass;
import accessdemo.ChildClass;
import accessdemo.SamePackageClass;

public class AccessDemoMain {
    public static void main(String[] args) {
        ParentClass parent = new ParentClass();
        parent.accessAllFromInside();

        System.out.println();

        ChildClass child = new ChildClass();
        child.accessFromChild();

        System.out.println();

        SamePackageClass samePkg = new SamePackageClass();
        samePkg.accessFromSamePackage();

        System.out.println();

        OtherPackageClass other = new OtherPackageClass();
        other.accessFromOtherPackage();

        System.out.println();

        OtherPackageClass.SubClassFromOtherPackage sub = new OtherPackageClass.SubClassFromOtherPackage();
        sub.tryAccess();
    }
}
