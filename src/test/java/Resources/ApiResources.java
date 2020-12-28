package Resources;

public enum ApiResources {

    order("api/v1/orders"),
    boq("boqs");

    private String resource;

    ApiResources(String resource)
    {
        this.resource=resource;
    };

    public String getResources()
    {
        return resource;
    }

}
