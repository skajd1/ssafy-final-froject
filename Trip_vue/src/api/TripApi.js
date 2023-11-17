import myaxios from "../utils/axios-common.js";

function getSido(success, fail) {
  myaxios.get("/trip/sido").then(success).catch(fail);
}

function getGugun(sidocode, success, fail) {
  myaxios.get(`/trip/sido/${sidocode}`).then(success).catch(fail);
}
function getTripInfo(sidoCode, gugunCode, typeid, success, fail) {
  myaxios.get(`/trip/sido/${sidoCode}/gugun/${gugunCode}/type/${typeid}`).then(success).catch(fail);
}
function getMyPlans(uid, success, fail) {
  myaxios.get(`/plan/${uid}`).then(success).catch(fail);
}

export { getGugun, getTripInfo, getSido, getMyPlans };