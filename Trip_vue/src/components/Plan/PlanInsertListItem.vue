<script setup>
import { defineProps, ref } from "vue";
import { usePlanStore } from "@/stores/planStore";

const planStore = usePlanStore();
const { deletePlanItem } = planStore;

const props = defineProps({ item: Object, key: Number });
const imgsrc = ref("");
imgsrc.value = props.item.content.firstImage;
</script>

<template>
  <div class="item">
    <div class="title">
      {{ item.content.title }}
    </div>
    <div class="content-box">
      <div class="content">
        <p>메모 : {{ item.memo }}</p>
        <p>예산 : {{ item.cost }}</p>
      </div>
      <div class="btn-box">
        <button @click="deletePlanItem(key)">삭제</button>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.item {
  margin: 5px;
  height: 120px;
  background-color: white;
  border-radius: 10px;
}
.title {
  width: 100%;
  color: var(--main-color);
  font-weight: bold;
  font-size: 18px;
  padding: 5px;
  border-bottom: 1px solid var(--main-color);
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.content-box {
  height: 80%;
  display: flex;
  justify-content: space-between;
  margin-left: 1rem;
  padding: 5px;
}

.content {
  height: 100%;
  display: flex;
  flex-direction: column;

  color: var(--main-color);

  font-size: 14px;
  padding: 5px;
}

.btn-box {
  height: 40%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 5px;
}
button {
  width: 100%;
  border: 1px solid var(--main-color);
  border-radius: 10px;
  background-color: white;
  color: var(--main-color);
  font-weight: bold;
}
</style>
