package ir.javacup.contest.zoo;

public class CageCopier {

    public void copy(Cage c1, Cage c2) {
        if (c1 == null || c2 == null)
            return;
        c2.setId(c1.getId());
        c2.setName(c1.getName());// String is immutable!! no need to copy;
        if (c1.getBirds() == null)
            c2.setBirds(null);
        else {
            Bird[] birds = new Bird[2];
            for (int i = 0; i < c1.getBirds().length; i++) {
                if (c1.getBirds()[i] == null)
                    continue;
                Bird bird = new Bird();
                bird.setName(c1.getBirds()[i].getName());
                bird.setColor(c1.getBirds()[i].getColor());
                birds[i] = bird;
            }
            c2.setBirds(birds);
        }
    }
}
