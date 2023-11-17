import myaxios from "../utils/axios-common.js";
function getMyPlans(uid, success, fail) {
  myaxios.get(`/plan/${uid}`).then(success).catch(fail);
}
function getPlanItems(pid, success, fail) {
  myaxios.get(`/plandetails/${pid}`).then(success).catch(fail);
}

export { getMyPlans, getPlanItems };
