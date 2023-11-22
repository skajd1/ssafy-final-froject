<script setup>
import { ref } from "vue";
import PlanDetail from "@/components/Plan/PlanDetail.vue";
import { useTripStore } from "@/stores/tripStore";
const props = defineProps({ t: Object });
const tripStore = useTripStore();

// 해당 여행지의 썸네일 이미지와 타이틀을 보여주는 컴포넌트
// 클릭하면 TripDetail 모달이 새로 뜬다. 거기엔 해당 여행지의 상세 정보가 담긴다.
const useModal = ref(false);

function showModal() {
  useModal.value = true;
}
const select = (trip) => {
  tripStore.select(trip);
};
</script>

<template>
  <PlanDetail :t="t" v-if="useModal == true" @close-modal="useModal = false" />

  <div class="item" @click="select(t)">
    <div id="imgbox">
      <img v-if="t.firstImage" :src="t.firstImage" alt="사진" />
      <img v-else src="@/assets/logo0.svg" alt="사진" />
    </div>
    <p>{{ t.title }}</p>
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
    margin: 10px 10px 0px 10px;
    font-weight: bold;
    color: var(--main-color);
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
