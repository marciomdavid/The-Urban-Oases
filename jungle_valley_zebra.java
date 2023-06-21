public class UrbanOases {
    public static void main(String[] args) {
         
        // Define a set of constants for the garden
        int MAX_PLANTS = 10;
        int MAX_TREES = 5;
        int MAX_SHRUBS = 15;
        int MAX_FLOWERS = 20;
 
        // Define an array to hold the plants
        Plant[] garden = new Plant[MAX_PLANTS];
 
        // Initialize the counter to keep track of plants
        int plantCount = 0;
 
        // Define and initialize a counter to keep track of trees
        int treeCount = 0;
 
        // Define and initialize a counter to keep track of shrubs
        int shrubCount = 0;
 
        // Define and initialize a counter to keep track of flowers
        int flowerCount = 0;
 
        // Add trees to the garden
        while (treeCount < MAX_TREES) {
            Tree tree = new Tree("oak");
            garden[plantCount] = tree;
            treeCount++;
            plantCount++;
        }
 
        // Add shrubs to the garden
        while (shrubCount < MAX_SHRUBS) {
            Shrub shrub = new Shrub("boxwood");
            garden[plantCount] = shrub;
            shrubCount++;
            plantCount++;
        }
 
        // Add flowers to the garden
        while (flowerCount < MAX_FLOWERS) {
            Flower flower = new Flower("daisy");
            garden[plantCount] = flower;
            flowerCount++;
            plantCount++;
        }
 
        // Print the garden
        System.out.println("The Urban Oases:");
        for (int i=0; i<plantCount; i++) {
            System.out.println(garden[i]);
        }
    }
 
    // Define the superclass
    abstract class Plant {
        // Instance variables
        protected String type;
 
        // Abstract methods
        public abstract void grow();
        public abstract void water();
        public abstract void trim();
 
        // Constructor
        public Plant(String type) {
            this.type = type;
        }
    }
 
    // Define the subclass Tree
    class Tree extends Plant {
 
        // Constructor
        public Tree(String type) {
            super(type);
        }
 
        // Implement the abstract methods
        @Override
        public void grow() {
            System.out.println(type + " tree is growing.");
        }
 
        @Override
        public void water() {
            System.out.println(type + " tree is being watered.");
        }
 
        @Override
        public void trim() {
            System.out.println(type + " tree is being trimmed.");
        }
    }
 
    // Define the subclass Shrub
    class Shrub extends Plant {
 
        // Constructor
        public Shrub(String type) {
            super(type);
        }
 
        // Implement the abstract methods
        @Override
        public void grow() {
            System.out.println(type + " shrub is growing.");
        }
 
        @Override
        public void water() {
            System.out.println(type + " shrub is being watered.");
        }
 
        @Override
        public void trim() {
            System.out.println(type + " shrub is being trimmed.");
        }
    }
 
    // Define the subclass Flower
    class Flower extends Plant {
 
        // Constructor
        public Flower(String type) {
            super(type);
        }
 
        // Implement the abstract methods
        @Override
        public void grow() {
            System.out.println(type + " flower is growing.");
        }
 
        @Override
        public void water() {
            System.out.println(type + " flower is being watered.");
        }
 
        @Override
        public void trim() {
            System.out.println(type + " flower is being trimmed.");
        }
    }
}