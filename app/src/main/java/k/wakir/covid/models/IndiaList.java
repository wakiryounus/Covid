package k.wakir.covid.models;

public class IndiaList {
    private String mName, mTotal, mCured, mActive, mDeath;

    public IndiaList(String name, String total, String cured, String active, String death) {
        mName = name;
        mTotal = total;
        mCured = cured;
        mActive = active;
        mDeath = death;
    }

    public IndiaList() {
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getTotal() {
        return mTotal;
    }

    public void setTotal(String total) {
        mTotal = total;
    }

    public String getCured() {
        return mCured;
    }

    public void setCured(String cured) {
        mCured = cured;
    }

    public String getActive() {
        return mActive;
    }

    public void setActive(String active) {
        mActive = active;
    }

    public String getDeath() {
        return mDeath;
    }

    public void setDeath(String death) {
        mDeath = death;
    }
}
