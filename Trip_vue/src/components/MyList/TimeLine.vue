<script setup>
import { ref, watch } from "vue";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import { useTripStore } from "@/stores/tripStore";
import TimeLineItem from "@/components/MyList/TimeLineItem.vue";
const tstore = useTripStore();
const { initItems } = tstore;

const store = usePlanStore();
const { items: storePlanItems } = storeToRefs(store);
const planItem = ref({});
watch(
  storePlanItems,
  () => {
    planItem.value = storePlanItems.value;
    initItems();
  },
  { deep: true }
);
</script>

<template>
  <div class="itembox">
    <TimeLineItem v-for="item in planItem" :planItem="item" />
  </div>
</template>

<style scoped>
.itembox {
  width: 100%;
  height: 100%;
  display: flex;
  overflow: auto;
}
</style>
