package k.wakir.covid.models;

public class ContinentList {
  private String mContinentName,  mUpdatedTime, mPopulation,
    mCases, mTodayCases, mDeaths, mTodayDeaths, mRecovered, mTodayRecovered, mActive,
    mCritical, mCasesPerOneMillion, mDeathsPerOneMillion, mTests, mTestPerOneMillion,
          mActivePerOneMillion, mRecoveredPerOneMillion, mCriticalPerOneMillion;

    public ContinentList(String continentName, String updatedTime, String population,
                         String cases, String todayCases, String deaths, String todayDeaths,
                         String recovered, String todayRecovered, String active, String critical,
                         String casesPerOneMillion, String deathsPerOneMillion, String tests,
                         String testPerOneMillion, String activePerOneMillion,
                         String recoveredPerOneMillion, String criticalPerOneMillion) {
        mContinentName = continentName;
        mUpdatedTime = updatedTime;
        mPopulation = population;
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
        mActivePerOneMillion = activePerOneMillion;
        mRecoveredPerOneMillion = recoveredPerOneMillion;
        mCriticalPerOneMillion = criticalPerOneMillion;
    }

    public ContinentList() {
    }

    public String getContinentName() {
        return mContinentName;
    }

    public void setContinentName(String continentName) {
        mContinentName = continentName;
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
