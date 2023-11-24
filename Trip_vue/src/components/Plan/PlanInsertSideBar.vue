<script setup>
import { ref } from "vue";
import PlanInsertConfirm from "@/components/Plan/PlanInsertConfirm.vue";
import PlanInsertList from "@/components/Plan/PlanInsertList.vue";
import PlanInsertInfo from "@/components/Plan/PlanInsertInfo.vue";
const useModal = ref(false);
const confirmInsert = () => {
  useModal.value = true;
  // 일정 제목을 입력할 모달창 띄우기
  // 제목 설정 후 등록 버튼 누르면 세션 uid 및 제목으로 plan 테이블 1개 생성
  // 그 후 store에 담긴 등록할 일정 planitem 테이블에 insert
};
</script>

<template>
  <div class="InsertSideBar">
    <PlanInsertConfirm v-if="useModal == true" @close-modal="useModal = false" />
    <div class="title">선택한 일정</div>
    <div class="list">
      <PlanInsertList />
    </div>
    <div class="list-info">
      <PlanInsertInfo />
    </div>
    <div class="btn-box">
      <button @click="confirmInsert()">등록</button>
    </div>
  </div>
</template>

<style scoped>
.InsertSideBar {
  width: 300px;
  height: 750px;
  background-color: var(--main-color-bg);
}
.title {
  width: 100%;
  height: 5%;
  font-size: 2.5rem;

  font-weight: bold;
  color: var(--main-color);
  display: flex;

  justify-content: center;
  align-items: center;
}
.list {
  width: 100%;
  height: 70%;
}
.list-info {
  width: 100%;
  height: 15%;
}
.btn-box {
  width: 100%;
  height: 5%;

  display: flex;
  justify-content: center;
}
button {
  width: 50%;
  height: 100%;
  border-radius: 10px;
  border: none;
  background-color: var(--main-color);
  color: white;
  font-weight: bold;
  font-size: 1.4rem;
}
</style>
