import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class App {

    public static void main(String[] args) throws Exception {

        // input as a string a comma delimited list of numbers
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        // Create a new instance of the NumberImplementer
        NumberImplementer summary = new NumberImplementer();

        // Call the collect method with the formatted string from the collect method
        String outputAns = summary.summarizeCollection(summary.collect(input));

        // Check if there are any valid inputs in the list
        // if no valid integers, output the messsage
        if (outputAns.equals("0")) {

            System.out.println("There are no valid inputs");

        } else {

            System.out.println(
                    // Output the result to terminal
                    "\n" + "Here are the list of numbers, grouping when they are sequential" + "\n" + outputAns);
        }

    }

    public interface NumberRangeSummarizer {

        // collect the input

        Collection<Integer> collect(String input);

        // get the summarized string
        String summarizeCollection(Collection<Integer> input);

    }

    // An implementation of the NumberRangeSummarizer interface that summarizes a
    // collection of integers by grouping consecutive numbers into ranges.
    public static class NumberImplementer implements NumberRangeSummarizer {

        @Override
        public Collection<Integer> collect(String input) {

            // Split the input string into an array of substrings using "," as the delimiter
            String[] item = input.split(",");

            // Create a new collection to hold the unique integers taken from the input
            Collection<Integer> result = new ArrayList<>();

            // list of all invalid inputs
            List<String> invalidInputs = new ArrayList<>();

            // Iterate over each item in the input string array
            for (String value : item) {

                // check if the item is a valid integer
                if (value.matches("\\d+")) {

                    // if it is a valid integer it is trimmed and added to the new Arraylist
                    int num = Integer.parseInt(value.trim());
                    result.add(num);
                } else {

                    // if it is not a valid integer it is added to the list of invalidInputs

                    invalidInputs.add(value);

                }
            }

            // Check if the invalidInputs list is empty
            if (invalidInputs.isEmpty()) {
                // no issues
            } else {

                // if list contains elements print a message indicating there are invalid inputs
                // and what they are
                System.out.println("Here are the invalid inputs: " + "\n");
                // Loop through the invalidInputs list and print each element
                for (String element : invalidInputs) {
                    System.out.print(element + "\n");
                }
            }

            // return the collected string
            return result;
        }

        @Override
        public String summarizeCollection(Collection<Integer> input) {

            // define list taking values from the parameters
            List<Integer> sortedList = new ArrayList<>(input);

            // Sort the elements in the list in ascending order
            Collections.sort(sortedList);

            // Create a new StringBuilder object to build the output string
            StringBuilder sb = new StringBuilder();

            // beginning number
            int start;

            // Check if the sortedList is not empty
            if (sortedList.size() > 0) {

                // If not empty, set the start variable to 0
                start = sortedList.get(0);
            } else {
                // handle the case where the list is empty
                start = 0;

            }

            // make final number that is equal to start number
            int end = start;

            // Loop through the sortedList
            for (int i = 1; i < sortedList.size(); i++) {

                // Get the current element from the list
                int current = sortedList.get(i);

                // Check if the current element is equal to +1 of previous element
                if (current == end + 1) {

                    // If it is, update the end variable to the current element
                    end = current;

                }

                else {
                    // If not, add the group to the stringbuilder
                    if (start == end) {
                        sb.append(start).append(", ");
                    } else {
                        sb.append(start).append("-").append(end).append(", ");
                    }

                    // update the start and end variables
                    start = current;
                    end = current;
                }
            }
            /// Add prev group to the output string
            if (start == end) {
                // If group has only one number, add it to stringbuilder
                sb.append(start);
            } else {
                // If the group consists of multiple numbers, output the string with a hyphen in
                // between the start and end numbers
                sb.append(start).append("-").append(end);
            }

            // Return entire built string
            return sb.toString();

        }
    }
}
