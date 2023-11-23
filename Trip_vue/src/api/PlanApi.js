import myaxios from "../utils/axios-common.js";
function getMyPlans(uid, success, fail) {
  myaxios.get(`/plan/${uid}`).then(success).catch(fail);
}
function getPlanItems(pid, success, fail) {
  myaxios.get(`/plandetails/${pid}`).then(success).catch(fail);
}
function makePlan(uid, title, success, fail) {
  myaxios.post(`/plan`, { uid: uid, title: title }).then(success).catch(fail);
}
function insertPlanItems(pid, params, success, fail) {
  myaxios.post(`/plandetails/${pid}`, params).then(success).catch(fail);
}

export { getMyPlans, getPlanItems, makePlan, insertPlanItems };
