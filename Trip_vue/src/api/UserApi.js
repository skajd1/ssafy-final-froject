import myaxios from "../utils/axios-common.js";
// 로그인
async function loginConfirm(id, pw, success, fail) {
  await myaxios.post("/trip/user/login", { id, pw }).then(success).catch(fail);
}
// 회원가입
async function regist(User, success, fail) {
  await myaxios.post("/trip/user", User).then(success).catch(fail);
}

// 회원정보
function getInfo(id, success, fail) {
  myaxios
    .get("/trip/user/id/" + id)
    .then(success)
    .catch(fail);
}

// 패스워드 변경
function changePw(User, success, fail) {
  myaxios.put("/trip/user", User).then(success).catch(fail);
}
// 회원 탈퇴
function deleteAccount(uid, success, fail) {
  myaxios
    .delete("/trip/user/uid/" + uid)
    .then(success)
    .catch(fail);
}
export { loginConfirm, regist, changePw, deleteAccount, getInfo };
