package lt.vu.mybatis.model;

public class Gunshop {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GUNSHOP.ID
     *
     * @mbg.generated Fri Mar 19 20:59:47 EET 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GUNSHOP.NAME
     *
     * @mbg.generated Fri Mar 19 20:59:47 EET 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.GUNSHOP.LICENCETYPE
     *
     * @mbg.generated Fri Mar 19 20:59:47 EET 2021
     */
    private String licencetype;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GUNSHOP.ID
     *
     * @return the value of PUBLIC.GUNSHOP.ID
     *
     * @mbg.generated Fri Mar 19 20:59:47 EET 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GUNSHOP.ID
     *
     * @param id the value for PUBLIC.GUNSHOP.ID
     *
     * @mbg.generated Fri Mar 19 20:59:47 EET 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GUNSHOP.NAME
     *
     * @return the value of PUBLIC.GUNSHOP.NAME
     *
     * @mbg.generated Fri Mar 19 20:59:47 EET 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GUNSHOP.NAME
     *
     * @param name the value for PUBLIC.GUNSHOP.NAME
     *
     * @mbg.generated Fri Mar 19 20:59:47 EET 2021
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.GUNSHOP.LICENCETYPE
     *
     * @return the value of PUBLIC.GUNSHOP.LICENCETYPE
     *
     * @mbg.generated Fri Mar 19 20:59:47 EET 2021
     */
    public String getLicencetype() {
        return licencetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.GUNSHOP.LICENCETYPE
     *
     * @param licencetype the value for PUBLIC.GUNSHOP.LICENCETYPE
     *
     * @mbg.generated Fri Mar 19 20:59:47 EET 2021
     */
    public void setLicencetype(String licencetype) {
        this.licencetype = licencetype;
    }
}