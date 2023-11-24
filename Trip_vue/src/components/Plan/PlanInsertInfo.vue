<script setup>
import { ref, watch } from "vue";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";

const planStore = usePlanStore();
const { tmpItems } = storeToRefs(planStore);

const costSum = ref(0);
const startDate = ref("");
const endDate = ref("");
watch(
  tmpItems,
  () => {
    console.log(tmpItems.value);
    startDate.value = tmpItems.value[0].date.split("T")[0];
    endDate.value = tmpItems.value[tmpItems.value.length - 1].date.split("T")[0];
    let tmp = 0;
    tmpItems.value.forEach((item) => {
      tmp += item.cost;
    });
    costSum.value = tmp;
  },
  { deep: true }
);
</script>

<template>
  <div class="info-box">
    <div class="period">{{ startDate }} ~ {{ endDate }}</div>
    <div class="costSum">총 예산 {{ costSum }}원</div>
  </div>
</template>

<style scoped>
.info-box {
  width: 95%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 0 auto;
  padding: 1rem;
  border-radius: 10px;
  background-color: white;
  box-shadow: 0 0 8px var(--main-color);
}
.costSum {
  font-size: 2rem;
  font-weight: bold;
  margin-bottom: 1rem;
  color: var(--main-color);
}
.period {
  font-size: 1.5rem;
  font-weight: bold;
  color: var(--main-color);
}
</style>
