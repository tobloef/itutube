package netflix.helpers;

import netflix.models.Credits;

import java.util.Random;
import java.util.ArrayList;
import java.util.UUID;

class FakeDataHelper {
    private static String[] fakeNames = {"Mario Speedwagon", "Petey Cruiser", "Anna Sthesia", "Anna Mull", "Gail Forcewind", "Nick R. Bocker", "Mike Hunt", "Don Stairs"};
    private static String[] fakeRoles = {"Directors", "Actors", "Cameramen", "Audio"};

    static Credits[] generateFakeCredits() {
        ArrayList<Credits> creditsList = new ArrayList<>();
        for(String s : fakeRoles) {
            ArrayList<String> people = new ArrayList<>();
            Random r = new Random();
            for (String p : fakeNames) {
                if (r.nextBoolean()) {
                    people.add(p);
                }
            }
            String[] peopleArray = new String[people.size()];
            creditsList.add(new Credits(s, people.toArray(peopleArray)));
        }
        Credits[] creditsArray = new Credits[creditsList.size()];
        creditsList.toArray(creditsArray);
        return creditsArray;
    }

    static String generateFakeDescription() {
        return "Lorem Ipsum Dolor Sit Amet";
    }

    static String generateFakeId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    static double generateFakeRating() {
        Random r = new Random();
        return (double) Math.round(r.nextDouble() * 10) / 10;
    }

    static int generateFakeRuntime() {
        Random r = new Random();
        return r.nextInt(10800);
    }
}
