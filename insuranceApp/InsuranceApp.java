// package insuranceApp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class InsurancePolicy{
    private String policyNumber;
    private String holderName;
    private double primiumAmount;

    public InsurancePolicy(String policyNumber, String holderName, double primiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.primiumAmount = primiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getPrimiumAmount() {
        return primiumAmount;
    }

    public void setPrimiumAmount(double primiumAmount) {
        this.primiumAmount = primiumAmount;
    }

    @Override
    public String toString() {
        return "InsurancePolicy [policyNumber=" + policyNumber + ", holderName=" + holderName + ", primiumAmount="
                + primiumAmount + "]";
    }
    
}

public class InsuranceApp {

    static void findMostFrequentWord(){
        String textCorpus = "This is a simple test. This test is simple, but it tests several things. Testing this test.";

        List<String> words = Arrays.stream(textCorpus.toLowerCase().split("\\W+"))
            .collect(Collectors.toList());

        Map<String, Long> wordFrequency = words.stream()
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        int topN = 3;
        List<Map.Entry<String, Long>> topWords = wordFrequency.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(topN)
            .collect(Collectors.toList());

        System.out.println("Top " + topN + " words:");
        topWords.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
   
    }

    static void findSecondMostRepeated(){

        String wordSequence = "apple banana apple orange banana apple grape orange grape grape";

        List<String> wordList = Arrays.stream(wordSequence.split("\\W+")).collect(Collectors.toList());

        Map<String, Long> wordCountMap = wordList.stream()
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        List<Map.Entry<String, Long>> sortedWordList = wordCountMap.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .collect(Collectors.toList());

        if (sortedWordList.size() > 1) {
            String secondMostRepeatedWord = sortedWordList.get(1).getKey();
            System.out.println("Second most repeated word: " + secondMostRepeatedWord);
        } else {
            System.out.println("Not enough data to find the second most repeated word.");
}

    }
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("POL001", "Alice", 5000.0),
            new InsurancePolicy("POL002", "Bob", 3000.0),
            new InsurancePolicy("POL003", "Charlie", 1500.0),
            new InsurancePolicy("POL004", "David", 1800.0),
            new InsurancePolicy("POL005", "Eve", 1000.0)
            );


        //1. filter primium amount
        List<InsurancePolicy> highPremiumPolicies = policies.stream().filter(p1 -> p1.getPrimiumAmount() > 1200).collect(Collectors.toList());
        System.out.println("High primium policy is greater than 1200: "+highPremiumPolicies);

        //2. sorted by name policy
        List<InsurancePolicy> sortedPolicies = policies.stream().sorted((p1,p2) -> p1.getHolderName().compareTo(p2.getHolderName())).collect(Collectors.toList());
        System.out.println("sorted policy is: "+sortedPolicies);

        //3. compute total primum
        double totalPrimium = policies.stream().mapToDouble(InsurancePolicy :: getPrimiumAmount).sum();
        System.out.println("Total primimum is: "+totalPrimium);

        //4. print policy details 
        System.out.println("Print policy details is: ");
        policies.forEach(policy -> System.out.println(
            String.format("Policy Number: %s, Holder: %s, primumAmount: $%.2f", policy.getPolicyNumber(), policy.getHolderName(), policy.getPrimiumAmount())
        ));

        //5.filter policy by primum range
        List<InsurancePolicy> primumRange = policies.stream().filter(p1 -> p1.getPrimiumAmount() >= 1000 && p1.getPrimiumAmount() <= 2000).collect(Collectors.toList());
        System.out.println("Primum range between 1000 and 2000 is: "+primumRange);

        //6. find Policy with highPremium
        Optional<InsurancePolicy> highPremimum = policies.stream().max(Comparator.comparingDouble(InsurancePolicy::getPrimiumAmount));
        System.out.println("Highest policy primium is: " + highPremimum);

        //7. Group policy by holder name
        Map<Character, List<InsurancePolicy>> groupedByInitial = policies.stream()
            .collect(Collectors.groupingBy(policy -> policy.getHolderName().charAt(0)));
        System.out.println("Policies grouped by holder name initial: " + groupedByInitial);

        //8. average primium 
        double averagePrimium = policies.stream().mapToDouble(InsurancePolicy::getPrimiumAmount).average().orElse(0.0);
        System.out.println("average primium is: "+averagePrimium);

        //9. sorted by primium amount
        List<InsurancePolicy> sortedByPrimium = policies.stream().sorted(Comparator.comparingDouble(InsurancePolicy::getPrimiumAmount)).collect(Collectors.toList());
        System.out.println("Sorted primimum is: ");
        sortedByPrimium.forEach(System.out::println);

        // 10. any High premium
        boolean anyHighPremium = policies.stream().anyMatch(policy -> policy.getPrimiumAmount() > 2000);
        System.out.println("Any high primum grater than 2000 or not: "+anyHighPremium);

        // 11. count policies for each range
        Map<String,Long> countPolices = policies.stream().collect(Collectors.groupingBy(policy ->
        { if(policy.getPrimiumAmount() <= 1000){
            return "Low <= 1000  ";
        }
        else if(policy.getPrimiumAmount() <= 2000){
            return "Medium <= 2000  ";
        }
        else{
            return "High > 2000  ";
        }
        },Collectors.counting()));
        System.out.println("Policy Count by Primium range: "+countPolices);

        //12. Extract unique Holder name
        List<String> uniqueName = policies.stream().map(InsurancePolicy::getHolderName).distinct().collect(Collectors.toList());
        System.out.println("Unique name is : "+uniqueName);

        //13. find by substring
        String suString = "Vid";
        List<InsurancePolicy> matchingPolicies= policies.stream().filter(policy -> policy.getHolderName().toLowerCase().contains(suString.toLowerCase())).collect(Collectors.toList());
        System.out.println("contains substring policy is: "+matchingPolicies);

        //14. Create a Map of Policy Numbers to Premium Amounts
        Map<String,Double> policyMap = policies.stream().collect(Collectors.toMap(InsurancePolicy::getPolicyNumber, InsurancePolicy::getPrimiumAmount));
        System.out.println("policy map is: "+policyMap);

        //15. Find the Most frequent words
        findMostFrequentWord();

        //16. Find the second most repeated words
        findSecondMostRepeated();
    }
}
