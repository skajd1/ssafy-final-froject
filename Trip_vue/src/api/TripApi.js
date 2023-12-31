import myaxios from "../utils/axios-common.js";

function getSido(success, fail) {
  myaxios.get("/trip/sido").then(success).catch(fail);
}

function getGugun(sidocode, success, fail) {
  myaxios.get(`/trip/sido/${sidocode}`).then(success).catch(fail);
}

function getTripInfo(param, success, fail) {
  myaxios.post("/trip/list", param).then(success).catch(fail);
}

function getTripInfoById(id, success, fail) {
  myaxios.get(`/trip/list/${id}`).then(success).catch(fail);
}
function getTripInfoByTitle(title, success, fail) {
  myaxios.get(`/trip/title/${title}`).then(success).catch(fail);
}
function getLikeListInfoByUid(uid, success, fail) {
  myaxios.get(`/trip/likelist/${uid}`).then(success).catch(fail);
}

export {
  getGugun,
  getSido,
  getTripInfo,
  getTripInfoById,
  getTripInfoByTitle,
  getLikeListInfoByUid,
};
