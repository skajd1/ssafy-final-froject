<script setup>
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import { useUserStore } from "@/stores/userStore";
const planStore = usePlanStore();
const userStore = useUserStore();
const { makePlanTable } = planStore;
const { user } = storeToRefs(userStore);
const emit = defineEmits(["closeModal"]);

const title = ref("");
const pid = ref("");
function insert() {
  closeModal();
  console.log("insert시작");
  pid.value = makePlanTable(user.uid, title);
}
function closeModal() {
  emit("closeModal");
}
</script>

<template>
  <div>
    <div class="black-bg">
      <div class="white-bg">
        <div class="title">일정의 제목을 입력해주세요</div>
        <div class="input-box">
          <input type="text" placeholder="어디가냥" v-model="title" />
        </div>
        <div class="btn-box">
          <button @click="insert()">등록</button>
          <button @click="closeModal()">닫기</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
div {
  box-sizing: border-box;
}
.black-bg {
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  position: fixed;
  left: 0;
  top: 0;

  display: flex;
  justify-content: center;
  align-items: center;

  /* padding: 20px; */
}
.white-bg {
  width: 100%;
  max-width: 500px;
  min-height: 500px;
  display: flex;
  flex-direction: column;
  margin: 100px auto;
  padding: 20px;
  border-radius: 8px;
  background: white;
  z-index: 10;
}
.title {
  margin-top: 40px;
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
  color: var(--main-color);
}
.input-box {
  width: 100%;
  height: 140px;
  border: 1px solid gray;
  border-radius: 10px;
  margin-bottom: 20px;
}
input {
  width: 100%;
  height: 100%;
  border: 1px solid var(--main-color);
  border-radius: 10px;
  outline-color: var(--main-color);
  outline-offset: 2px;
  border-radius: 10px;
  padding: 0 10px;
  font-size: 5rem;
  color: var(--main-color);
}
input::placeholder {
  color: var(--vt-c-bg);
}
.btn-box {
  margin-top: 180px;
  width: 100%;
  height: 50px;
  display: flex;
  justify-content: space-between;
}
button {
  width: 48%;
  height: 100%;
  border: none;
  border-radius: 10px;
  background-color: var(--main-color);
  color: white;
  font-weight: bold;
  font-size: 1.4rem;
}
</style>
