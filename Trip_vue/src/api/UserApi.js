import myaxios from "../utils/axios-common.js";

function userConfirm(param, success, fail) {
  myaxios.post(`/user/login`, param).then(success).catch(fail);
}
export { userConfirm };
