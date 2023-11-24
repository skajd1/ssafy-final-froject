import { ref } from "vue";
import { defineStore } from "pinia";
import { getLikeInfo, insertLike, deleteLike } from "../api/AttractionLikeApi";

const useAlikeStore = defineStore("useAlikeStore", () => {
  const alike = ref(false);

  const getLike = (content_id, uid) => {
    getLikeInfo(
      content_id,
      uid,
      (res) => {
        if (res.data == 1) {
          alike.value = true;
        } else {
          alike.value = false;
        }
      },
      (err) => {
        console.log(err);
      }
    );
  };

  const insertLike = (content_id, uid) => {
    insertLike(
      content_id,
      uid,
      (res) => {
        if (res.data == 1) {
          alike.value = true;
        } else {
          alike.value = false;
        }
      },
      (err) => {
        console.log(err);
      }
    );
  };

  const deleteLike = (content_id, uid) => {
    deleteLike(
      content_id,
      uid,
      (res) => {
        if (res.data == 1) {
          alike.value = true;
        } else {
          alike.value = false;
        }
      },
      (err) => {
        console.log(err);
      }
    );
  };

  return { getLike, deleteLike, insertLike };
});

export { useAlikeStore };
