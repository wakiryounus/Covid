package k.wakir.covid.models;

public class CountryList {
   private String mCountryName, mImageUrl,  mUpdatedTime, mPopulation, mContinent,
           mCases, mTodayCases, mDeaths, mTodayDeaths, mRecovered, mTodayRecovered, mActive,
           mCritical, mCasesPerOneMillion, mDeathsPerOneMillion, mTests, mTestPerOneMillion, mOneCasePerPeople,
           mOneDeathsPerPeople, mOneTestPerPeople, mActivePerOneMillion, mRecoveredPerOneMillion, mCriticalPerOneMillion;

    public CountryList(String countryName, String imageUrl, String updatedTime,
                       String population, String continent, String cases, String todayCases,
                       String deaths, String todayDeaths, String recovered, String todayRecovered,
                       String active, String critical, String casesPerOneMillion, String deathsPerOneMillion,
                       String tests, String testPerOneMillion, String oneCasePerPeople, String oneDeathsPerPeople,
                       String oneTestPerPeople, String activePerOneMillion, String recoveredPerOneMillion,
                       String criticalPerOneMillion) {
        mCountryName = countryName;
        mImageUrl = imageUrl;
        mUpdatedTime = updatedTime;
        mPopulation = population;
        mContinent = continent;
        mCases = cases;
        mTodayCases = todayCases;
        mDeaths = deaths;
        mTodayDeaths = todayDeaths;
        mRecovered = recovered;
        mTodayRecovered = todayRecovered;
        mActive = active;
        mCritical = critical;
        mCasesPerOneMillion = casesPerOneMillion;
        mDeathsPerOneMillion = deathsPerOneMillion;
        mTests = tests;
        mTestPerOneMillion = testPerOneMillion;
        mOneCasePerPeople = oneCasePerPeople;
        mOneDeathsPerPeople = oneDeathsPerPeople;
        mOneTestPerPeople = oneTestPerPeople;
        mActivePerOneMillion = activePerOneMillion;
        mRecoveredPerOneMillion = recoveredPerOneMillion;
        mCriticalPerOneMillion = criticalPerOneMillion;
    }

    public CountryList() {
    }

    public String getCountryName() {
        return mCountryName;
    }

    public void setCountryName(String countryName) {
        mCountryName = countryName;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getUpdatedTime() {
        return mUpdatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        mUpdatedTime = updatedTime;
    }

    public String getPopulation() {
        return mPopulation;
    }

    public void setPopulation(String population) {
        mPopulation = population;
    }

    public String getContinent() {
        return mContinent;
    }

    public void setContinent(String continent) {
        mContinent = continent;
    }

    public String getCases() {
        return mCases;
    }

    public void setCases(String cases) {
        mCases = cases;
    }

    public String getTodayCases() {
        return mTodayCases;
    }

    public void setTodayCases(String todayCases) {
        mTodayCases = todayCases;
    }

    public String getDeaths() {
        return mDeaths;
    }

    public void setDeaths(String deaths) {
        mDeaths = deaths;
    }

    public String getTodayDeaths() {
        return mTodayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        mTodayDeaths = todayDeaths;
    }

    public String getRecovered() {
        return mRecovered;
    }

    public void setRecovered(String recovered) {
        mRecovered = recovered;
    }

    public String getTodayRecovered() {
        return mTodayRecovered;
    }

    public void setTodayRecovered(String todayRecovered) {
        mTodayRecovered = todayRecovered;
    }

    public String getActive() {
        return mActive;
    }

    public void setActive(String active) {
        mActive = active;
    }

    public String getCritical() {
        return mCritical;
    }

    public void setCritical(String critical) {
        mCritical = critical;
    }

    public String getCasesPerOneMillion() {
        return mCasesPerOneMillion;
    }

    public void setCasesPerOneMillion(String casesPerOneMillion) {
        mCasesPerOneMillion = casesPerOneMillion;
    }

    public String getDeathsPerOneMillion() {
        return mDeathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(String deathsPerOneMillion) {
        mDeathsPerOneMillion = deathsPerOneMillion;
    }

    public String getTests() {
        return mTests;
    }

    public void setTests(String tests) {
        mTests = tests;
    }

    public String getTestPerOneMillion() {
        return mTestPerOneMillion;
    }

    public void setTestPerOneMillion(String testPerOneMillion) {
        mTestPerOneMillion = testPerOneMillion;
    }

    public String getOneCasePerPeople() {
        return mOneCasePerPeople;
    }

    public void setOneCasePerPeople(String oneCasePerPeople) {
        mOneCasePerPeople = oneCasePerPeople;
    }

    public String getOneDeathsPerPeople() {
        return mOneDeathsPerPeople;
    }

    public void setOneDeathsPerPeople(String oneDeathsPerPeople) {
        mOneDeathsPerPeople = oneDeathsPerPeople;
    }

    public String getOneTestPerPeople() {
        return mOneTestPerPeople;
    }

    public void setOneTestPerPeople(String oneTestPerPeople) {
        mOneTestPerPeople = oneTestPerPeople;
    }

    public String getActivePerOneMillion() {
        return mActivePerOneMillion;
    }

    public void setActivePerOneMillion(String activePerOneMillion) {
        mActivePerOneMillion = activePerOneMillion;
    }

    public String getRecoveredPerOneMillion() {
        return mRecoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(String recoveredPerOneMillion) {
        mRecoveredPerOneMillion = recoveredPerOneMillion;
    }

    public String getCriticalPerOneMillion() {
        return mCriticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(String criticalPerOneMillion) {
        mCriticalPerOneMillion = criticalPerOneMillion;
    }
}
