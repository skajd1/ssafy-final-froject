<script setup>
import PlanInsertListItem from "@/components/Plan/PlanInsertListItem.vue";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import { ref, watch, reactive, computed } from "vue";
const planStore = usePlanStore();

const { tmpItems } = storeToRefs(planStore);
const tripList = ref([]);
const NumberOfDate = ref(0);
let set;

// 1일차, 2일차 등 날짜별로 묶기
const getDayNumber = (date) => {
  const index = Object.keys(organizedTripList.value).indexOf(date);
  return index + 1;
};
watch(
  tmpItems,
  () => {
    //tmpItems의 date를 기준으로 정렬

    tripList.value = tmpItems.value.sort((a, b) => {
      let d1 = new Date(a.date.split("T")[0]);
      let d2 = new Date(b.date.split("T")[0]);
      return d1 - d2;
    });
    set = new Set();
    tripList.value.forEach((item) => {
      set.add(item.date.split("T")[0]);
    });
    NumberOfDate.value = set.size;
  },
  { deep: true }
);
const organizedTripList = computed(() => {
  const groupedItems = {};
  tripList.value.forEach((item) => {
    const date = item.date.split("T")[0];
    if (!groupedItems[date]) {
      groupedItems[date] = [];
    }
    groupedItems[date].push(item);
  });
  return groupedItems;
});
</script>

<template>
  <div class="container">
    <div id="items">
      <div v-for="(items, date) in organizedTripList" :key="date">
        <div class="date">{{ getDayNumber(date) }}일차: {{ date }}</div>
        <PlanInsertListItem v-for="item in items" :item="item" :key="item.id"></PlanInsertListItem>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.container {
  width: 100%;
  height: 100%;

  /* border: 1px solid var(--main-color); */

  #items {
    border-radius: 10px;
    box-shadow: 0 0 5px var(--main-color);
    overflow-y: auto;
    margin-top: 10px;
    padding: 0;
    width: 100%;
    height: 500px;
  }

  .date {
    margin: 10px;
    font-weight: bolder;
    color: white;
    background-color: var(--main-color);
    border-radius: 10px;
    padding: 2px;
    padding-left: 50px;
  }
  ::-webkit-scrollbar {
    width: 10px;
  }

  ::-webkit-scrollbar-thumb {
    background-color: var(--main-color);
    border-radius: 10px;
  }
}
</style>
