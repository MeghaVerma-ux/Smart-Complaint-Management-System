public class Complaint {

    static int counter = 1;

    int id;

    String category;

    String description;

    String status;

    Complaint(
            String category,
            String description
    ){

        this.id = counter++;

        this.category = category;

        this.description = description;

        this.status = "Pending";
    }

    public String toString(){

        return "ID: "
                + id
                + " | "
                + category
                + " | "
                + description
                + " | "
                + status;
    }
}