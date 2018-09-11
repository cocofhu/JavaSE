package introsp;

public class PEntity {
	private int id ;
	private String name ;
	private boolean start ;
	public PEntity(int id, String name, boolean start) {
		super();
		this.id = id;
		this.name = name;
		this.start = start;
	}
	public PEntity() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	@Override
	public String toString() {
		return "PEntity [id=" + id + ", name=" + name + ", start=" + start + "]";
	}
	
}
