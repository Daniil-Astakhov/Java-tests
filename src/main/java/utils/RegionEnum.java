package utils;

public enum RegionEnum {
    RU("RU"),
    KZ("KZ"),
    All("All");

    private String name;

    RegionEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
