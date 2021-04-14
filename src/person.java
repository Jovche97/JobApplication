public class person implements Comparable< person > {
	private	String Name;
	private String LastName;
	private int age;  

		person(String Name, String LastName, int age){
			this.setName(Name);
			this.setLastName(LastName);
			this.setAge(age);
		}

		public person() {
			// TODO Auto-generated constructor stub
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getLastName() {
			return LastName;
		}

		public void setLastName(String lastName) {
			LastName = lastName;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		@Override
		public String toString() {
			return "person [Name=" + Name + ", LastName=" + LastName + ", age=" + age + "]";
		}

		@Override 
		public int compareTo(person p1){
	        int compareage = ((person)p1).getAge();
	        return this.age - compareage;
		}
}
