<script setup>
import TripDetail from "./TripDetail.vue";
import { ref } from "vue";

const emit = defineEmits(["changeList"]);
defineProps({ t: Object, list: Array });

// 해당 여행지의 썸네일 이미지와 타이틀을 보여주는 컴포넌트
// 클릭하면 TripDetail 모달이 새로 뜬다. 거기엔 해당 여행지의 상세 정보가 담긴다.
const useModal = ref(false);

function showModal() {
  useModal.value = true;
}

const changeList = () => {
  emit("changeList");
};
</script>

<template>
  <TripDetail
    :t="t"
    :list="list"
    v-if="useModal == true"
    @close-modal="useModal = false"
    @changeList="changeList"
  />
  <div class="item" @click="showModal()">
    <h3>{{ t.title }}</h3>
    <div id="imgbox">
      <img v-if="t.firstImage" :src="t.firstImage" alt="사진" />
      <img v-else src="@/assets/logo0.svg" alt="사진" />
    </div>
  </div>
</template>

<style scoped>
h3 {
  padding-bottom: 5px;
  margin: 10px;
  width: 100%;
  text-align: center;
  font-weight: bold;
  color: var(--main-color);
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
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

  border-radius: 10px;
  box-shadow: 0 0 8px var(--main-color);
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
