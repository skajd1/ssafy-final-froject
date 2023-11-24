<script setup>
import { ref, watch, onMounted } from "vue";
import { useTripStore } from "@/stores/tripStore";
import { usePlanStore } from "@/stores/planStore";
import { useUserStore } from "@/stores/userStore";
import { storeToRefs } from "pinia";
import { getLikeInfo, insertLike, deleteLike } from "@/api/AttractionLikeApi";

// import PlanDetail from "@/components/Plan/PlanDetail.vue";

const useStore = useUserStore();
const { user } = storeToRefs(useStore);

const props = defineProps({
  t: Object,
  index: Number,
});
const tripStore = useTripStore();

const { getlikelist } = storeToRefs(tripStore);
const { getLikeListInfo } = tripStore;

// 해당 여행지의 썸네일 이미지와 타이틀을 보여주는 컴포넌트
// 클릭하면 TripDetail 모달이 새로 뜬다. 거기엔 해당 여행지의 상세 정보가 담긴다.

const select = (trip) => {
  tripStore.select(trip);
};

const alike = ref(false);

// const find = (list, key, value) => {
//   // console.log(list   , key, value);
//   return list.find((item) => item[key] === value);
// };

// onMounted(() => {
//   // console.log(getlikelist.value);
//   if (find(getlikelist.value, "title", props.t.title)) {
//     alike.value = true;
//   }
// });

// 좋아요 여부 확인
// const getLike = () => {
//   getLikeInfo(
//     user.value.uid,
//     props.t.contentId,
//     (res) => {
//       if (res.data == true) {
//         alike.value = true;
//         getLikeListInfoByUid(user.value.uid);
//       } else {
//         alike.value = false;
//       }
//     },
//     (err) => {
//       console.log(err);
//     }
//   );
// };
getlikelist.value.forEach((item) => {
  if (item.contentId === props.t.contentId) {
    alike.value = true;
  }
});
// 좋아요 추가
const InsertLike = () => {
  insertLike(
    props.t.contentId,
    user.value.uid,
    (res) => {
      if (res.data == 1) {
        alike.value = true;
        // getLikeListInfo(user.value.uid);
      } else {
        alike.value = false;
      }
    },
    (err) => {
      console.log(err);
    }
  );
};

// 좋아요 삭제
const DeleteLike = () => {
  deleteLike(
    props.t.contentId,
    user.value.uid,
    (res) => {
      if (res.data >= 1) {
        alike.value = false;
      } else {
        alike.value = true;
      }
    },
    (err) => {
      console.log(err);
    }
  );
};
</script>

<template>
  <!-- <PlanDetail :t="t" v-if="modal == true" @close-modal="useModal = false" /> -->

  <div class="item" @click="select(t)">
    <div id="imgbox">
      <img v-if="t.firstImage" :src="t.firstImage" alt="사진" />
      <img v-else src="@/assets/logo0.svg" alt="사진" />
    </div>
    <p>{{ t.title }}</p>
    <button>
      <div v-if="alike === false" @click="InsertLike">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="12"
          height="12"
          fill="currentColor"
          class="bi bi-heart"
          viewBox="0 0 16 16"
        >
          <path
            d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15"
          />
        </svg>
      </div>
      <div class="delete" v-else @click="DeleteLike">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="12"
          height="12"
          fill="currentColor"
          class="bi bi-heart-fill"
          viewBox="0 0 16 16"
        >
          <path
            color="red"
            fill-rule="evenodd"
            d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314"
          />
        </svg>
      </div>
    </button>
  </div>
</template>

<style lang="scss" scoped>
.item {
  display: flex;
  flex-direction: row;
  margin: 5px;
  cursor: pointer;

  /* box-shadow: 0 0 5px var(--main-color); */
  height: 90px;
  background-color: white;
  border-radius: 10px;

  P {
    margin: 10px 2px 0px 10px;
    font-weight: bold;
    color: var(--main-color);

    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }

  button {
    margin-top: 5px;
    margin-right: 20px;
    height: 30px;
    border: none;
    background-color: transparent;
    color: red;
    display: flex;
    align-items: center;
  }

  #imgbox {
    margin-left: 10px;
    margin-top: 20px;

    img {
      width: 50px;
      height: 50px;
    }
  }
}
</style>
