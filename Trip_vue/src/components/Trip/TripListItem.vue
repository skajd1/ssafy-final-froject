<script setup>
import { ref } from "vue";
import TripDetail from "./TripDetail.vue";
defineProps({ t: Object });

// 해당 여행지의 썸네일 이미지와 타이틀을 보여주는 컴포넌트
// 클릭하면 TripDetail 모달이 새로 뜬다. 거기엔 해당 여행지의 상세 정보가 담긴다.
const useModal = ref(false);

function showModal() {
  useModal.value = true;
}
</script>

<template>
  <TripDetail :t="t" v-if="useModal == true" @close-modal="useModal = false" />
  <div class="item" @click="showModal()">
    <h3>{{ t.title }}</h3>
    <div id="imgbox">
      <img v-if="t.firstImage" :src="t.firstImage" alt="사진" />
      <img v-else src="@/assets/logo0.svg" alt="사진" />
    </div>
  </div>
</template>

<style scoped>
.item {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: 0 1rem;
  padding: 0.5rem;
  white-space: nowrap;
  width: 600px;
  height: 60rem;

  border: 1px solid rgb(12, 11, 11);
  border-radius: 0.5rem;
}
#imgbox {
  width: 600px;
  height: 100%;
  border-radius: 0.5rem;
  overflow: hidden;
  padding: 0.5rem;
}
img {
  width: 100%;
  height: 100%;
  border-radius: 0.5rem;
}
</style>
