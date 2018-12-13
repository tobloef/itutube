package netflix.helpers;

import netflix.models.Credits;
import netflix.models.MediaList;
import netflix.models.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Generates placeholder data for media objects.
 */
public class FakeData {
    private static String[] fakeNames = {"Mario Speedwagon", "Petey Cruiser", "Anna Sthesia", "Anna Mull", "Gail Forcewind", "Nick R. Bocker", "Mike Hunt", "Don Stairs"};
    private static String[] fakeRoles = {"Directors", "Actors", "Cameramen", "Audio"};
    private static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent nibh tortor, fermentum efficitur rutrum et, euismod ac orci. Integer mi enim, hendrerit ac suscipit eget, interdum vitae purus. Ut iaculis nunc quis metus suscipit consectetur. Donec porta vulputate odio, sed molestie metus ultricies a. Cras sed lacus rutrum, interdum libero eu, fringilla leo. Proin neque massa, fringilla non massa a, egestas suscipit neque. Phasellus fermentum leo felis, sit amet mollis turpis faucibus ut. Maecenas auctor malesuada nulla. Proin at tincidunt urna. Phasellus sed nulla id tortor facilisis egestas. Nullam pretium accumsan tristique. Aliquam elit odio, sodales id pellentesque at, eleifend non orci. Vestibulum aliquet magna eu augue rutrum tincidunt. Sed sed arcu tellus. Donec commodo in libero non bibendum. Vivamus eget neque nec tortor lacinia accumsan a et enim. Suspendisse vel dignissim mauris, et gravida purus. Aenean vitae dictum metus, sodales feugiat diam. Sed vehicula molestie purus sed consequat. Donec dapibus porta efficitur. Integer semper tristique ex, a egestas nisl luctus ut. Donec consectetur leo nec orci sollicitudin mattis. Donec sagittis metus ut lorem consequat placerat. Aliquam pellentesque est ac augue convallis, eu dignissim nisl congue. Phasellus volutpat blandit sem, scelerisque vestibulum ipsum condimentum vel. Praesent fringilla at magna ac accumsan. Suspendisse nec hendrerit ex. Donec sollicitudin et enim a mattis. Proin gravida lectus mattis ante euismod, a aliquet nulla luctus. Duis vestibulum nec sapien nec hendrerit. Nulla a purus in nibh porttitor scelerisque. Phasellus tempor dictum posuere. Fusce facilisis sem et nibh pharetra, vitae vulputate nunc efficitur. Phasellus lobortis venenatis porta. Duis ut orci porta, placerat metus non, volutpat nulla. Ut rhoncus ipsum at velit convallis, vel scelerisque purus egestas. Integer lobortis dolor nibh, sit amet iaculis purus dapibus ornare. Nullam viverra imperdiet dui vel ultricies. Nullam venenatis venenatis vestibulum. Aenean volutpat elit ut sem placerat eleifend. Fusce id semper lectus. Donec ultricies quam vel massa tincidunt tristique. Etiam viverra arcu ultrices elementum interdum. Aenean a ipsum purus. Donec rutrum semper sodales. Morbi eleifend leo nisi, at vestibulum arcu tempor nec. Vivamus dictum lobortis dolor ut sagittis. Proin feugiat sit amet dolor ac maximus. Sed consectetur sed turpis vitae pharetra. Maecenas eget auctor nisi. In non nibh congue, elementum dui in, pulvinar nibh. Nam tincidunt rutrum urna vel aliquam. Morbi eu porttitor libero, a imperdiet ex. Integer id vestibulum odio, vitae vehicula ipsum. Nam diam tellus, imperdiet at libero in, lacinia cursus ligula. Fusce blandit porttitor facilisis. Donec at nulla libero. Phasellus elementum est diam, et lacinia mauris venenatis ac. Sed laoreet nibh ac nulla pellentesque molestie. Nulla a gravida quam. Suspendisse potenti. Morbi quis pretium tortor, nec lacinia augue. Vestibulum eget est ut nulla porttitor ultricies et vitae eros. Integer sed convallis lacus. Quisque facilisis viverra mollis. Morbi semper nisl risus.Vivamus at nulla eleifend, malesuada lacus id, malesuada ante. Integer in dictum nisl. Sed at arcu nisl. Duis blandit purus in nisi consectetur sollicitudin. Praesent dapibus quam massa, sed faucibus nibh convallis vel. Duis vitae faucibus odio. Fusce augue lorem, interdum ac enim nec, dapibus mattis nisi. Aenean orci odio, blandit eu libero et, volutpat tincidunt lacus. Morbi consequat scelerisque diam vitae tempus. Nullam eget est ac ex vehicula varius. Sed in leo at sem maximus ornare. Ut imperdiet, neque in ullamcorper feugiat, diam leo fringilla erat, vitae ullamcorper ligula nibh nec tellus. In iaculis sapien quis consequat vulputate. Donec eu mauris ac enim ornare pharetra. Quisque volutpat odio a nisi mollis, vel finibus mauris fermentum. Cras aliquet leo ut sapien venenatis, in finibus sapien auctor. Phasellus vitae odio et ligula gravida tempor. Ut nisl libero, rutrum vel ornare id, laoreet in velit. Aenean posuere, nibh nec tincidunt aliquet, est tortor rhoncus lacus, nec porta nibh elit quis orci. Cras nibh neque, convallis in lobortis vel, rhoncus eget purus. Phasellus consequat leo nec nulla hendrerit, et vulputate nisl egestas. Nam enim tellus, malesuada sed leo a, porta rhoncus tortor. Etiam malesuada egestas mi, eu ornare velit cursus ut. Aenean massa tellus, suscipit quis risus ac, tempor viverra massa. Etiam placerat ante a ante volutpat auctor nec faucibus lorem. In in dui dapibus ligula tincidunt porttitor in at ante. Praesent laoreet magna nisl, nec tincidunt lorem hendrerit sed. Mauris sit amet quam vel sapien efficitur consequat eleifend in nunc. Mauris viverra justo rutrum consequat porta. Integer varius velit id ligula venenatis, eget vehicula augue vestibulum. Phasellus non sapien quis dolor luctus interdum sit amet ut tortor. Etiam vestibulum convallis mi, quis pharetra odio posuere ac. In laoreet viverra neque, sit amet commodo ex dictum fermentum. Quisque vel ante et massa ultricies consectetur in et orci. Morbi suscipit ante augue, ut maximus ipsum feugiat dictum. Vivamus et scelerisque est. Proin imperdiet in dui vel vehicula. Nunc euismod urna vitae sem cursus sollicitudin. Quisque suscipit quis justo ut commodo. Donec eu varius enim. Aenean urna metus, consequat id turpis et, tincidunt convallis purus. Aliquam iaculis sapien non elit convallis, eget suscipit risus pharetra. Curabitur efficitur, mauris vitae scelerisque mollis, nulla arcu facilisis erat, in tincidunt erat est sit amet ex. Suspendisse nec arcu ac magna feugiat posuere. Nunc a ante ipsum. Integer gravida, orci quis ultricies scelerisque, tortor nibh feugiat neque, vel luctus eros mi eu dolor. Integer lacinia enim nec magna pellentesque imperdiet. Morbi aliquet mi vitae orci suscipit, et interdum mi ultricies. Phasellus mauris sapien, consectetur vel eros vel, mollis accumsan lorem. Cras at elit quis enim tincidunt facilisis. Sed sed leo augue. Nulla metus massa, suscipit ut imperdiet quis, aliquam ut magna. Duis lobortis arcu ullamcorper, bibendum nisi ac, condimentum diam. Donec tincidunt quam quis neque luctus ultrices. Proin arcu velit, ultrices vel nibh et, maximus venenatis massa. In hac habitasse platea dictumst. Mauris in congue magna. Pellentesque et diam quis felis viverra placerat non non est. Ut eu accumsan enim. Maecenas ut risus faucibus, interdum elit accumsan, vestibulum ligula. Ut pulvinar gravida sapien, vitae sodales eros ultricies vel. Fusce magna ligula, ornare sed consectetur at, convallis non elit. Sed tempor luctus risus, ut lobortis libero congue ut. Integer scelerisque sagittis enim. Sed felis quam, ultrices eleifend.";

    public static Credits[] generateFakeCredits() {
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

    /**
     * Generates a string of a set length, that contains lorem ipsum.
     * @param characters The length of the string in characters.
     * @return String of lorem ipsum text.
     */
    public static String getLoremIpsum(int characters) {
        return loremIpsum.substring(0, Math.min(characters, loremIpsum.length()));
    }

    /**
     * Generates an alphanumeric ID using UUID.
     * @return Random ID.
     */
    public static String generateFakeId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * Generates a random double from 0 to 10 with one decimal.
     * @return Random rating.
     */
    public static double generateFakeRating() {
        Random r = new Random();
        return (double) Math.round(r.nextDouble() * 100)/10;
    }

    /**
     * Generates a random integer from 0 to 10800, representing the runtime of a media.
     * @return Random integer.
     */
    public static int generateFakeRuntime() {
        Random r = new Random();
        return r.nextInt(10800);
    }

    /**
     * Generates a random list of media from the database.
     * @param media List of media.
     * @param min Minimal length of the list.
     * @param max Maximal length of the list.
     * @return Random list of media.
     */
    public static List<Media> generateRandomListOfMedia(List<Media> media, int min, int max) {
        List<Media> listOfMedia = new ArrayList<>();
        Random rand = new Random();
        int amount = min + new Random().nextInt(max-min+1);
        for (int i = 0; i < amount; i++) {
            if (media.size() == 0) {
                continue;
            }
            int randomIndex = rand.nextInt(media.size());
            listOfMedia.add(media.get(randomIndex));
        }
        return listOfMedia;
    }

    /**
     * Generates a list of MediaList objects from a list of media.
     * @param media List of media
     * @return Customized random media lists.
     */
    public static List<MediaList> generateFakeFeaturedLists(List<Media> media) {
        List<MediaList> mediaLists = new ArrayList<>();
        mediaLists.add(new MediaList(
                "Tobias' Top Picks",
                generateRandomListOfMedia(media, 5, 15)
        ));
        mediaLists.add(new MediaList(
                "Nicolai's Special List",
                generateRandomListOfMedia(media, 5, 15)
        ));
        mediaLists.add(new MediaList(
                "Julian's Favorites",
                generateRandomListOfMedia(media, 5, 15)
        ));
        return mediaLists;
    }
}
