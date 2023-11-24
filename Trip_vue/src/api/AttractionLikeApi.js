import myaxios from "../utils/axios-common.js";

function getLikeInfo(uid, content_id, success, fail) {
  myaxios.get(`/trip/attractionlike/${content_id}/${uid}`).then(success).catch(fail);
}

function insertLike(content_id, uid, success, fail) {
  myaxios
    .post(`/trip/attractionlike`, { content_id: content_id, uid: uid })
    .then(success)
    .catch(fail);
}

function deleteLike(content_id, uid, success, fail) {
  let params = {
    content_id: content_id,
    uid: uid,
  };
  myaxios.post(`/trip/likecancel`, params).then(success).catch(fail);
}

function getLikeCount(success, fail) {
  myaxios.get("/trip/likecount").then(success).catch(fail);
}

export { getLikeInfo, insertLike, deleteLike, getLikeCount };
