
public class Parser {

	public static void main(String[] args) {
		ReadWrite parser = new ReadWrite(args[0], args[1]);
		parser.splitNotes();
	}

}
