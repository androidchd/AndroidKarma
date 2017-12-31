package Helper;


import android.content.Context;
import android.content.SharedPreferences;


public class App_Common {
    private static App_Common instance = null;
    private static Context context;


    public static final String WebServiceUrl = "http://50.62.134.38:9191/service.svc/";
    public static final String TAG = "KarmaGolF";
    public static final String WorkHorseNo = "+919699903200";


    public static App_Common getInstance(Context _context) {
        if (instance == null)
            instance = new App_Common();

        context = _context;
        return instance;
    }

    // ---------------------Login--------------------


    public void setLoginS(boolean chkLogin) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putBoolean(Prefs.login, chkLogin);

        prefsEditor.commit();
    }

    public boolean getLoginS() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getBoolean(Prefs.login, false);
    }

    // ---------------------User Name--------------------
    public void setUserName(String userName) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();

        prefsEditor.putString(Prefs.userName, userName);
        prefsEditor.commit();

    }

    public String getUserName() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.userName, null);
    }

    //--------------------- User Password --------------
    public void setUserPwd(String userPwd) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.password, userPwd);
        prefsEditor.commit();
    }

    public String getUserPwd() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.password, null);
    }

    //-----------------------------token number------------
    public void setUserToken(String userToken) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.token, userToken);
        prefsEditor.commit();
    }

    public String getUserToken() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.token, null);
    }


    // ----------------- Email ID ----------------------
    public void setUserEmailId(String userId) {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.email, userId);
        prefsEditor.commit();
    }

    public String getUserEmailId() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.email, null);
    }

    //-------------------- User Number -----------------
    public void setUserNumber(String userNumber) {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.userNo, userNumber);
        prefsEditor.commit();
    }

    public String getUserNumber() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.userNo, null);
    }
    //------------------------- User Facebook ID -------------


    public boolean setLoginStatus(boolean loginStatus) {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putBoolean(Prefs.LOGIN, loginStatus);
        prefsEditor.commit();
        return loginStatus;
    }

    public boolean getLoginStatus() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getBoolean(Prefs.LOGIN, Boolean.parseBoolean(null));
    }

    // ---------------------Registered--------------------

    public void setRegistered(boolean Registered) {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putBoolean(Prefs.registerd, Registered);
        prefsEditor.commit();
    }

    public boolean getRegistered() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getBoolean(Prefs.registerd, false);
    }

    public void setUserID(String userID) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.userId, userID);
        prefsEditor.commit();
    }

    public String getUserID() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.userId, null);
    }

    public void setTimeselected(String timeselected) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.timeselected, timeselected);
        prefsEditor.commit();

    }

    public String getTimeselected() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.timeselected, null);
    }

    public void setMemeber(boolean Member) {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putBoolean(Prefs.member, Member);
        prefsEditor.commit();
    }

    public boolean getMember() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getBoolean(Prefs.member, false);
    }


    public void setMemberPlayer(String memberplayer) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.memberplayer, memberplayer);
        prefsEditor.commit();
    }

    public String getMemberPlayer() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.memberplayer, null);
    }

    public void setNonMemberPlayer(String nonmemberplayer) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.nonmemberplayer, nonmemberplayer);
        prefsEditor.commit();
    }

    public String getNonMemberPlayer() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.nonmemberplayer, null);
    }


    public void setMemeberupdate(boolean Member) {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putBoolean(Prefs.memberupdate, Member);
        prefsEditor.commit();
    }

    public boolean getMemberupdate() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getBoolean(Prefs.memberupdate, false);
    }

    public void setMemberFee(String memberfee) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.memberfee, memberfee);
        prefsEditor.commit();
    }

    public String getMemberfee() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.memberfee, null);
    }

    public void setNonMemberFee(String nonmemberfee) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.nonmemberfee, nonmemberfee);
        prefsEditor.commit();
    }

    public String getNonMemberfee() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.nonmemberfee, null);
    }


    public void setReferralcode(String userCode) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.referralcode, userCode);
        prefsEditor.commit();
    }

    public String getReferralcode() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.referralcode, null);
    }

    public void setMemberShipId(String memberShipId) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.membershipId, memberShipId);
        prefsEditor.commit();
    }

    public String getMemberShipId() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.membershipId, null);
    }

    public void sethitonce(boolean hitonce) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putBoolean(Prefs.hitonce, hitonce);

        prefsEditor.commit();
    }

    public boolean gethitonce() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getBoolean(Prefs.hitonce, false);
    }

    //-----------------totalScore------------------
    public void setFinalTotalScore(String totalscore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.totalScore, totalscore);
        prefsEditor.commit();
    }

    public String getFinalTotalScore() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.totalScore, null);
    }

    public void setTotalDetailScore(String totalscore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.totalDetailScore, totalscore);
        prefsEditor.commit();
    }

    public String getTotalDetailScore() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.totalDetailScore, null);
    }

    public void setTotalPuts(String puts) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.totalDetailPuts, puts);
        prefsEditor.commit();
    }

    public String getTotalPuts() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.totalDetailPuts, null);
    }

    public void setTotalStrokes(String totalscore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.totalDetailStroke, totalscore);
        prefsEditor.commit();
    }

    public String getTotalStrokes() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.totalDetailStroke, null);
    }

    //--------------------------------------------------------------
    public void setDate(String date) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.dateselected, date);
        prefsEditor.commit();
    }

    public String getDateselected() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.dateselected, null);
    }

    public void setHolescore1(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore1, holescore);
        prefsEditor.commit();
    }

    public String getHolescore1() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore1, null);
    }

    public void setHolescore2(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore2, holescore);
        prefsEditor.commit();
    }

    public String getHolescore2() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore2, null);
    }

    public void setHolescore3(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore3, holescore);
        prefsEditor.commit();
    }

    public String getHolescore3() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore3, null);
    }

    public void setHolescore4(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore4, holescore);
        prefsEditor.commit();
    }

    public String getHolescore4() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore4, null);
    }

    public void setHolescore5(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore5, holescore);
        prefsEditor.commit();
    }

    public String getHolescore5() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore5, null);
    }

    public void setHolescore6(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore6, holescore);
        prefsEditor.commit();
    }

    public String getHolescore6() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore6, null);
    }

    public void setHolescore7(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore7, holescore);
        prefsEditor.commit();
    }

    public String getHolescore7() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore7, null);
    }

    public void setHolescore8(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore8, holescore);
        prefsEditor.commit();
    }

    public String getHolescore8() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore8, null);
    }

    public void setHolescore9(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore9, holescore);
        prefsEditor.commit();
    }

    public String getHolescore9() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore9, null);
    }

    public void setHolescore10(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore10, holescore);
        prefsEditor.commit();
    }

    public String getHolescore10() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore10, null);
    }

    public void setHolescore11(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore11, holescore);
        prefsEditor.commit();
    }

    public String getHolescore11() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore11, null);
    }

    public void setHolescore12(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore12, holescore);
        prefsEditor.commit();
    }

    public String getHolescore12() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore12, null);
    }

    public void setHolescore13(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore13, holescore);
        prefsEditor.commit();
    }

    public String getHolescore13() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore13, null);
    }

    public void setHolescore14(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore14, holescore);
        prefsEditor.commit();
    }

    public String getHolescore14() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore14, null);
    }

    public void setHolescore15(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore15, holescore);
        prefsEditor.commit();
    }

    public String getHolescore15() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore15, null);
    }

    public void setHolescore16(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore16, holescore);
        prefsEditor.commit();
    }

    public String getHolescore16() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore16, null);
    }

    public void setHolescore17(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore17, holescore);
        prefsEditor.commit();
    }

    public String getHolescore17() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore17, null);
    }

    public void setHolescore18(String holescore) {
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(Prefs.holescore18, holescore);
        prefsEditor.commit();
    }

    public String getHolescore18() {
        SharedPreferences myPrefs = context.getSharedPreferences(
                Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.holescore18, null);
    }

    public void setUserCode(String userCode) {
        // TODO Auto-generated method stub
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();

        prefsEditor.putString(Prefs.userCode, userCode);
        prefsEditor.commit();
    }

    public String getUserCode() {
        // TODO Auto-generated method stub
        SharedPreferences myPrefs = context.getSharedPreferences(Prefs.PREFS_NAME, context.MODE_PRIVATE);
        return myPrefs.getString(Prefs.userCode, null);
    }


}
