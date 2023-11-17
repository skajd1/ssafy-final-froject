<script setup>
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import TimeLineItem from "@/components/MyList/TimeLineItem.vue";
const store = usePlanStore();
const { items: items } = storeToRefs(store);
</script>

<template>
  <div class="itembox">
    <TimeLineItem v-for="item in items" :item="item" />
  </div>
</template>

<style scoped>
.itembox {
  width: 100%;
  height: 100%;
  display: flex;
}
</style>
