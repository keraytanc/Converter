module org.example {
    requires javafx.controls;
    requires jakarta.xml.bind;
    exports org.example;
    opens org.example.domain to jakarta.xml.bind;
}
