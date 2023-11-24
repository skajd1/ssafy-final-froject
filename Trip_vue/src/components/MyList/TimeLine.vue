<script setup>
import { ref, watch } from "vue";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import { useTripStore } from "@/stores/tripStore";
import TimeLineItem from "@/components/MyList/TimeLineItem.vue";
const tstore = useTripStore();
const { initTripItems, getTripItems } = tstore;
// const { items: storeTripItems } = storeToRefs(tstore);
const store = usePlanStore();
const { items: storePlanItems } = storeToRefs(store);
const planItems = ref({});
watch(
  storePlanItems,
  () => {
    console.log("일정 캐시 초기화");
    initTripItems();
    planItems.value = storePlanItems.value;
    planItems.value.forEach((item) => {
      getTripItems(item.content_id);
    });
  },
  { deep: true }
);
</script>

<template>
  <div class="itembox">
    <TimeLineItem v-for="(item, index) in planItems" :planItem="item" :index="index" />
  </div>
</template>

<style lang="scss" scoped>
.itembox {
  display: flex;

  width: 1000px;
  height: 100%;

  overflow: auto;
}

::-webkit-scrollbar {
  height: 8px;
}

::-webkit-scrollbar-track {
  background-color: var(--main-color-bg);
  border-radius: 10px;
}

::-webkit-scrollbar-thumb {
  background-color: var(--main-color);
  border-radius: 10px;
}
</style>
