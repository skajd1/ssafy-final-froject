<script setup>
import MyListItem from "@/components/MyList/MyListItem.vue";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import { ref, reactive } from "vue";
const store = usePlanStore();
const { allPlan } = store;
const { all: items } = storeToRefs(store);
const uid = ref(1);
allPlan(uid.value);
</script>

<template>
  <div>내 계획들 확인하는 뷰에용</div>
  <div class="container">
    <MyListItem v-for="item in items" :item="item" :key="item.pid" />
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
