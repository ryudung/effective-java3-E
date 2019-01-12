package ch04.item24;

public class NonStaticMemberClass {
    private String name;

    private class InnerClass{
        private String innerName;

        public String getInnerName() {
            return innerName;
        }

        public String getName(){
            //바깥 클래스의 필드에 접근 가능.
            return name;
        }
    }
}
