
package ke.co.droidsense.remotedev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RemoteOkResponse {

    @SerializedName("legal")
    @Expose
    private String legal;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("epoch")
    @Expose
    private String epoch;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("company_logo")
    @Expose
    private String companyLogo;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("original")
    @Expose
    private Boolean original;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("url")
    @Expose
    private String url;

    public String getLegal() {
        return legal;
    }

    public void setLegal(String legal) {
        this.legal = legal;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getOriginal() {
        return original;
    }

    public void setOriginal(Boolean original) {
        this.original = original;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}