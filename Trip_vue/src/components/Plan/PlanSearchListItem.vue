<script setup>
import { ref, watch } from "vue";
// import PlanDetail from "@/components/Plan/PlanDetail.vue";
import { useTripStore } from "@/stores/tripStore";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
const props = defineProps({
  t: Object,
  index: Number,
});
const tripStore = useTripStore();

// 해당 여행지의 썸네일 이미지와 타이틀을 보여주는 컴포넌트
// 클릭하면 TripDetail 모달이 새로 뜬다. 거기엔 해당 여행지의 상세 정보가 담긴다.

const select = (trip) => {
  tripStore.select(trip);
};

const like = () => {
  console.log("test");
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
    <button @click="like">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="10"
        height="10"
        fill="currentColor"
        class="bi bi-heart"
        viewBox="0 0 16 16"
      >
        <path
          d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15"
        />
      </svg>
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
