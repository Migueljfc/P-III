package aula4.ex3;

import java.util.LinkedList;

public class ClientList {
	private LinkedList<Person> clientList = new LinkedList<Person>();

	public void addClient(Person client) {
		clientList.add(client);
	}

	public void removeClient(Person client) {
		clientList.remove(client);
	}

	public void list() {
		System.out.println("List: (1 - Staff , 2 - Student");
		System.out.printf("%10s || %10s || %10s || %10s || %10s || %10s\n", "Name", "CC Number", "Birthday",
				"Member Number", "Staff Number / Mec Number", "NIF / Course");
		System.out.println("----------------------------------------------------------------------------------");
		for (int i = 0; i < clientList.size(); i++) {
			System.out.println(clientList.get(i).toString());
		}
	}

	public Person search(int nMember) {
		for (int i = 0; i < clientList.size(); i++) {
			if (clientList.get(i).nMember() == nMember)
				return clientList.get(i);
		}
		throw new IllegalArgumentException();
	}

	public int size() {
		return clientList.size();
	}

}
