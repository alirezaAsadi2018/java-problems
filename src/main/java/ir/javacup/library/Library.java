package ir.javacup.library;

import java.security.SecureRandom;
import java.util.Arrays;

public class Library {

    private final int capacity;
    private int size;
    private Member[] members;
    private IdGenerator idGenerator;

    public Library(int capacity, IdGenerator idGenerator) {
        this.capacity = capacity;
        this.members = new Member[capacity];
        this.idGenerator = idGenerator;
    }

    public void register(Member member) throws LibraryFullException {
        if (isFull())
            throw new LibraryFullException("Library is full");
        if (member == null)
            throw new IllegalArgumentException("member is null");
        if(member.getFirstName() == null)
            throw new IllegalArgumentException("member.firstName is null");
        if(member.getLastName() == null)
            throw new IllegalArgumentException("member.lastName is null");
        int id = idGenerator.generate();
        member.setId(id);
        for (int i = 0; i < capacity; i++) {
            if(members[i] == null) {
                members[i] = member;
                break;
            }
        }
        ++size;
    }

    public Member unregister(int id) {
        for (int i = 0; i < capacity; i++) {
            if(members[i] != null && members[i].getId().equals(id)) {
                --size;
                Member member = members[i];
                members[i] = null;
                return member;
            }
        }
        throw new MemberNotFoundException("No member found with the given id");
    }

    public int getMemberCount() {
        return size;
    }

    public boolean isFull() {
        return getMemberCount() == capacity;
    }

    public Member[] getMembers() {
        return members;
    }

    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) throws LibraryFullException {
        SecureRandom secureRandom = new SecureRandom();
        Library library = new Library(2, secureRandom::nextInt);
        Member member;
        int[] ids = new int[2];

        for (int j = 0; j < 2; j++) {
            member = new Member();
            member.setFirstName("ali");
            member.setLastName("asadi");
            library.register(member);
            System.out.println(Arrays.toString(library.members));
        }
        int i = 0;
        for (Member member1 : library.members) {
            ids[i++] = member1.getId();
        }
        for (int j = 0; j < 2; j++) {
            library.unregister(ids[j]);
            System.out.println(Arrays.toString(library.members));
        }
    }
}
