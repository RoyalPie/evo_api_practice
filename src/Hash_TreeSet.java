import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//class NhanVien implements Comparable<NhanVien>{
//    Integer id;
//    int age;
//    String name;
//
//    NhanVien(int id, String name, int age){
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//    @Override
//    public String toString() {
//        return "Nhan Vien id=" + id + ",age=" + age + ",name=" + name;
//    }
//    @Override
//    public int compareTo(NhanVien nv) {
//        return this.getId().compareTo(nv.getId());
//    }
//}
class NhanVien{
    Integer id;
    int age;
    String name;

    NhanVien(int id, String name, int age){
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Nhan Vien id=" + id + ",age=" + age + ",name=" + name;
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NhanVien employee = (NhanVien) obj;
        return id == employee.id;
    }
}

class HocSinh {
    String name;
}
public class Hash_TreeSet {
    public static void main(String[] args) {
        NhanVien nv1 = new NhanVien(1,"Tran Van Nam", 29);
        NhanVien nv2 = new NhanVien(2,"Khuat Thu Trang", 24);
        NhanVien nv3 = new NhanVien(3,"Nguyen Thi Mai", 20);
        NhanVien nv4 = new NhanVien(4,"Dang Thi Duyen", 49);
        NhanVien nv5 = new NhanVien(4,"Nam Van Hue", 34);

        Set<NhanVien> tree = new HashSet<>();
        tree.add(nv1);
        tree.add(nv2);
        tree.add(nv3);
        tree.add(nv4);
        tree.add(nv5);

        for (NhanVien nv : tree) {
            System.out.println(nv.toString());
        }

    }
}

