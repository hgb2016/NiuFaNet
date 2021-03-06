package com.dream.NiuFaNet.Api;


import com.dream.NiuFaNet.Bean.ApplyBeFrendBean;
import com.dream.NiuFaNet.Bean.BannerBean;
import com.dream.NiuFaNet.Bean.CalInviteBean;
import com.dream.NiuFaNet.Bean.CalendarDetailBean;
import com.dream.NiuFaNet.Bean.CalenderedBean;
import com.dream.NiuFaNet.Bean.CaseDetailBean;
import com.dream.NiuFaNet.Bean.CaseListBean;
import com.dream.NiuFaNet.Bean.ChatBean;
import com.dream.NiuFaNet.Bean.ClientDataBean;
import com.dream.NiuFaNet.Bean.ClientDescBean;
import com.dream.NiuFaNet.Bean.CommonBean;
import com.dream.NiuFaNet.Bean.CommonBean1;
import com.dream.NiuFaNet.Bean.ConflictCalBean;
import com.dream.NiuFaNet.Bean.EditCount;
import com.dream.NiuFaNet.Bean.FriendNoticeBean;
import com.dream.NiuFaNet.Bean.FunctionBean;
import com.dream.NiuFaNet.Bean.MyToolsBean;
import com.dream.NiuFaNet.Bean.HeadPortraitBean;
import com.dream.NiuFaNet.Bean.InputGetBean;
import com.dream.NiuFaNet.Bean.LoginBean;
import com.dream.NiuFaNet.Bean.MainFunctionBean;
import com.dream.NiuFaNet.Bean.MarkDateBean;
import com.dream.NiuFaNet.Bean.MyFrendBean;
import com.dream.NiuFaNet.Bean.NewCalResultBean;
import com.dream.NiuFaNet.Bean.NewProResultBean;
import com.dream.NiuFaNet.Bean.ProgramDetailBean;
import com.dream.NiuFaNet.Bean.ProgramListBean;
import com.dream.NiuFaNet.Bean.ProjectClientListBean;
import com.dream.NiuFaNet.Bean.RecomendBean;
import com.dream.NiuFaNet.Bean.RegisterBean;
import com.dream.NiuFaNet.Bean.RemindWordBean;
import com.dream.NiuFaNet.Bean.SearchUserBean;
import com.dream.NiuFaNet.Bean.ShareBean;
import com.dream.NiuFaNet.Bean.ShowCountBean;
import com.dream.NiuFaNet.Bean.UserInfoBean;
import com.dream.NiuFaNet.Bean.VersionBean;
import com.dream.NiuFaNet.Bean.VoiceRvBean;
import com.dream.NiuFaNet.Bean.WorkVisibleBean;
import com.dream.NiuFaNet.Other.Const;
import com.dream.NiuFaNet.Ui.Fragment.ProjectFragment;

import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * 接口集中类
 * Created by Administrator on 2017/4/7/007.
 */
public interface NFApiService {
  
    //首页推荐list
    @FormUrlEncoded
    @POST(Const.app+"apiQuestion.do")
    Observable<RecomendBean> getRecomendData(@Field("id") String user_id);

    //问答
    @FormUrlEncoded
    @POST(Const.app+"nfVoice.do")
    Observable<ChatBean> getChatAnswer(@Field("id") String id, @Field("text") String text, @Field("type") String type, @Field("IMEI") String token);

    //反馈
    @FormUrlEncoded
    @POST(Const.app+"apiFeedback.do")
    Observable<CommonBean> toFeedBack(@FieldMap Map<String, String> map);

    //获取验证码
    @FormUrlEncoded
    @POST(Const.app+"apiCaptcha.do")
    Observable<CommonBean> getYzCode(@Field("mobilePhone") String mobilePhone, @Field("type") String type);

    //注册
    @FormUrlEncoded
    @POST(Const.app+"apiRegister.do")
    Observable<RegisterBean> toRegister(@Field("mobilePhone") String mobilePhone, @Field("captcha") String captcha, @Field("password") String password);

    //登录
    @FormUrlEncoded
    @POST(Const.app+"apiLogin.do")
    Observable<LoginBean> toLogin(@Field("mobilePhone") String mobilePhone, @Field("password") String password);

    //第三方（微信、qq）登录
    @FormUrlEncoded
    @POST(Const.app+"apiThirdLogin.do")
    Observable<LoginBean> toLogin(@Field("openId") String openId, @Field("unionId") String unionId, @Field("nickName") String nickName, @Field("loginType") String loginType,@Field("headUrl") String headUrl);

    //编辑用户信息
    @FormUrlEncoded
    @POST(Const.app+"apiEditUser.do")
    Observable<CommonBean> editUserInfo(@Field("user") String user);

    //找回密码
    @FormUrlEncoded
    @POST(Const.app+"apiFindPassword.do")
    Observable<CommonBean> findbackPWD(@Field("mobilePhone") String mobilePhone, @Field("captcha") String captcha, @Field("password") String password);

    //修改密码
    @FormUrlEncoded
    @POST(Const.app+"apiUpdPassword.do")
    Observable<CommonBean> editPWD(@Field("userId") String userId, @Field("oldPassword") String oldPassword, @Field("newPassword") String newPassword);

    //绑定手机
    @FormUrlEncoded
    @POST(Const.app+"apiBindingPhone.do")
    Observable<LoginBean> bindPhone(@Field("mobilePhone") String mobilePhone, @Field("captcha") String captcha, @Field("userId") String userId);

    //图片上传
    @Multipart
    @POST(Const.app+"apiImage.do")
    Observable<HeadPortraitBean> updateHeadPortrait(@Part MultipartBody.Part fdImg_file, @Part("userId") RequestBody userId);

    //图片上传（错误示范）
    @FormUrlEncoded
    @POST(Const.app+"apiImage.do")
    Observable<HeadPortraitBean> updateHeadPortrait(@Field("file") File fdImg_file, @Field("userId") String userId);

    //分享
    @FormUrlEncoded
    @POST(Const.app+"apiShare.do")
    Observable<ShareBean> shareAPP(@Field("userId") String userId);

    //功能
    @FormUrlEncoded
    @POST(Const.app+"apiAction.do")
    Observable<FunctionBean> getFunctionData(@Field("type") String userId);

    //版本更新
    @FormUrlEncoded
    @POST(Const.app+"apiVersions.do")
    Observable<VersionBean> requestVersion(@Field("type") String type, @Field("version") String version);

    //首页banner
    @FormUrlEncoded
    @POST(Const.app+"apiBanner.do")
    Observable<BannerBean> getBannerData(@Field("type") String type);

    //首页功能
    @FormUrlEncoded
    @POST(Const.app+"apiIndexAction.do")
    Observable<MainFunctionBean> getMainFunction(@Field("type") String type);

    //创建日程
    @Headers({Const.token})
    @Multipart
    @POST(Const.app+"createSchedule.do")
    Observable<NewCalResultBean> addCalender(@Part("data") RequestBody data, @Part MultipartBody.Part[] mFile);

    //获取日程列表
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchScheduleByDay.do")
    Observable<CalenderedBean> getCalenders(@Field("userId") String userId, @Field("beginTime") String beginTime, @Field("endTime") String endTime);

    //查看日程
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchSchedule.do")
    Observable<CalendarDetailBean> getCalendarDetail(@Field("userId") String userId,@Field("scheduleId") String scheduleId);

    //删除日程图片
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"deletePic.do")
    Observable<CommonBean> deletePic(@Field("id") String picId);

    //删除日程
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"deleteSchedule.do")
    Observable<CommonBean> deleteCalendar(@Field("scheduleId") String scheduleId,@Field("inviteUserId") String inviteUserId);

    //修改日程
    @Headers({Const.token})
    @Multipart
    @POST(Const.app+"editSchedule.do")
    Observable<NewCalResultBean> edtCalender(@Part("data") RequestBody data, @Part MultipartBody.Part[] mFile);

    //提示语
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"prompt.do")
    Observable<RemindWordBean> getRemindWord(@Field("id") String id);

    //语音提取
    @FormUrlEncoded
    @POST("niufa_chatbot/schedule.do")
    Observable<List<InputGetBean>> getInputWord(@Field("text") String text);

    //创建项目
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"createProject.do")
    Observable<NewProResultBean> newProgram(@Field("data") String data);

    //项目列表
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchProjectList.do")
    Observable<ProgramListBean> getProgramlist(@Field("userId") String userId,@FieldMap Map<String, String> map);

    //根据项目获取日程
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchProjectSchedule.do")
    Observable<CommonBean> searchProjectSchedule(@Field("projectId") String projectId);

    //项目详情
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchProject.do")
    Observable<ProgramDetailBean> getProjectDetail(@Field("projectId") String projectId,@Field("userId") String userId ,@Field("page") String page);

    //编辑项目
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"editProject.do")
    Observable<CommonBean> edtProject(@Field("data") String data);

    //删除项目
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"deleteProject.do")
    Observable<CommonBean> deleteProject(@Field("projectId") String projectId);

    //搜索用户
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchUsers.do")
    Observable<SearchUserBean> searchUser(@Field("keyWord") String keyWord);

    //我的好友列表
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchFriends.do")
    Observable<MyFrendBean> getMyFrends(@Field("userId") String userId);

    //添加好友
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"inviteFriends.do")
    Observable<CommonBean> addFrend(@Field("userId") String userId,@Field("friendId") String friendId);

    //陌生人的添加好友请求
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"addFriendNotice.do")
    Observable<ApplyBeFrendBean> applyBeFrend(@Field("userId") String userId);

    //答复好友申请
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"replyAddFriend.do")
    Observable<CommonBean> answerApply(@Field("id") String id,@Field("status") String status);

    //日程邀请的通知
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"scheduleNotice.do")
    Observable<CalInviteBean> getCalInviteList(@Field("userId") String userId);

    //答复日程邀请
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"replySchedule.do")
    Observable<CommonBean> replySchedule(@Field("scheduleId") String scheduleId,@Field("status") String status,@Field("userId") String userId,@Field("rejectRemark") String rejectRemark);

    //删除日程参与人
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"deleteParticipant.do")
    Observable<CommonBean> deleteParticipant(@Field("scheduleId") String scheduleId,@Field("userId") String userId,@Field("inviteUserId") String inviteUserId);

    //删除日程参与人
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"sendMsg.do")
    Observable<CommonBean> sendMsg(@Field("mobile") String phoneNum,@Field("userId") String userId,@Field("userName") String userName);

    //添加工作可见的好友
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"addWorkVisible.do")
    Observable<CommonBean> addWorkVisible(@Field("data") String data);

    //删除工作可见用户
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"deleteWorkVisible.do")
    Observable<CommonBean> deleteWorkVisible(@Field("userId") String userId,@Field("user_id") String user_id);

    //查找工作可见用户
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"workVisible.do")
    Observable<WorkVisibleBean> getWorkVisible(@Field("userId") String userId);

    //查找工作可见用户
    @Headers({Const.token})
    @POST(Const.app+"voicePrompt.do")
    Observable<VoiceRvBean> voicePrompt();

    //导出日程
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"exportProjectSchedule.do")
    Observable<CommonBean> exportProjectSchedule(@FieldMap Map<String,String> map);

    /**
     *新接口
     */

    //获取标记日期
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchScheduleShowDate.do")
    Observable<MarkDateBean> getMakeDate(@Field("userId") String userId,@Field("beginTime") String beginTime,@Field("endTime") String endTime);

    //获取用户信息
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"selectUserById.do")
    Observable<UserInfoBean> getUserInfo(@Field("user") String user);

    //获取好友信息（通讯录）
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchFriendInfo.do")
    Observable<UserInfoBean> searchFriendInfo(@Field("userId") String userId,@Field("friendId") String friendId);

    //删除我的好友（通讯录）
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"deleteUserFriends.do")
    Observable<CommonBean> deleteUserFriends(@Field("userId") String userId,@Field("friendId") String friendId);

    //编辑好友备注
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"editFriendRemark.do")
    Observable<CommonBean> editFriendRemark(@Field("userId") String userId,@Field("friendId") String friendId,@Field("friendRemark") String friendRemark);

    //邀请好友
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"inviteFriends.do")
    Observable<CommonBean> inviteFriends(@Field("userId") String userId,@Field("friendId") String friendId);

    //获取我的好友邀请通知
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchFriendNotice.do")
    Observable<FriendNoticeBean> searchFriendNotice(@Field("userId") String userId);

    //接受好友邀请
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"receiveFriend.do")
    Observable<CommonBean> receiveFriend(@Field("userId") String userId,@Field("friendId") String friendId);

    //查询我的好友邀请未读数量
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchFriendNoticeShowCount.do")
    Observable<ShowCountBean> searchFriendNoticeShowCount(@Field("userId") String userId);

    //编辑日程提醒
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"editScheduleRemind.do")
    Observable<CalendarDetailBean> editScheduleRemind(@Field("data") String data);

    //编辑日程(局部)
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"editScheduleInfo.do")
    Observable<CommonBean> editScheduleInfo(@Field("data") String data);

    //获取我的常用工具
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"selectMyTools.do")
    Observable<MyToolsBean> selectMyTools(@Field("userId") String userId);

    //编辑我的常用工具
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"editMyTools.do")
    Observable<CommonBean> editMyTools(@Field("data") String data);

    //验证是否有项目的查看权限
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"validateProjectShow.do")
    Observable<CommonBean1> validateProjectShow(@FieldMap Map<String,String> map);

    //Android包上传
    @Multipart
    @POST(Const.app+"apiUploadApk.do")
    Observable<CommonBean> uploadApk(@Part MultipartBody.Part fdImg_file, @Part("version") RequestBody version);

    //创建客户
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"addMyClient.do")
    Observable<CommonBean> addMyClient(@Field("data") String data);

    //获取我的用户集合
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchMyClients.do")
    Observable<ClientDataBean> searchMyClients(@Field("userId") String userId,@FieldMap Map<String,String> map);


    //根据客户编号查看客户详情
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchMyClientDesc.do")
    Observable<ClientDescBean> searchMyClientDesc(@Field("userId") String userId, @Field("clientId") String clientId);

    //删除客户信息
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"deleMyClient.do")
    Observable<CommonBean> deleMyClient(@Field("userId") String userId,@Field("clientId") String clientId);

    //删除客户下的联系人
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"deleMyClientContact.do")
    Observable<CommonBean> deleMyClientContact(@Field("userId") String userId,@Field("clientId") String clientId,@Field("id") String id);

    //删除客户下的谁可见
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"deleMyClientUser.do")
    Observable<CommonBean> deleMyClientUser(@Field("userId") String userId,@Field("clientId") String clientId,@Field("id") String id);


    //修改或新增常用联系人
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"addClientContact.do")
    Observable<CommonBean> addClientContact(@Field("data") String data);

    //新增谁可见
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"addClientShowUser.do")
    Observable<CommonBean> addClientShowUser(@Field("data") String data);

    //按客户排序查询项目
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchProjectClientList.do")
    Observable<ProjectClientListBean> searchProjectClientList(@FieldMap Map<String,String> map);

    //用户所有下的更新项目
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"searchProjectIsEditCount.do")
    Observable<EditCount> searchProjectIsEditCount(@Field("userId") String userId);


    //导出我的日程
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"exportMySchedule.do")
    Observable<CommonBean> exportMySchedule(@FieldMap Map<String,String> map);

    //验证日程的时间是否有冲突
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"validateScheduleData.do")
    Observable<ConflictCalBean> validateScheduleData(@FieldMap Map<String,String> map);


    //创建日程验证日程的时间是否有冲突
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"validateScheduleDataAdd.do")
    Observable<ConflictCalBean> validateScheduleDataAdd(@FieldMap Map<String,String> map);

    //获取案件列表
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"selectCaseInfoList.do")
    Observable<CaseListBean> selectCaseInfoList(@FieldMap Map<String,String> map);

    //获取案件详情
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"selectCaseInfo.do")
    Observable<CaseDetailBean> selectCaseInfo(@Field("userId") String userId, @Field("caseId") String caseId);

    //案件竞标
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"addCaseOrder.do")
    Observable<CommonBean> addCaseOrder(@FieldMap Map<String,String> map);

    //检验是否重复竞标
    @Headers({Const.token})
    @FormUrlEncoded
    @POST(Const.app+"validateCaseOrder.do")
    Observable<CommonBean1> validateCaseOrder(@Field("userId") String userId, @Field("caseId") String caseId);
}
