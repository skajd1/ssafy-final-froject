<script setup>
import { watchEffect, ref } from "vue";
import { useTripStore } from "@/stores/tripStore";
import { storeToRefs } from "pinia";

const store = useTripStore();
const { getTripItem } = store;
const { item: t } = storeToRefs(store);
const props = defineProps({
  item: Object,
});
const title = ref();
const address = ref();
const imgsrc = ref();
</script>

<template>
  <div class="timeline-item">
    {{ item.content_id }}
    {{ item.date.split(" ")[0] }}
    {{ title }}
    {{ address }}
    <img :src="imgsrc" />
  </div>
</template>

<style scoped>
.timeline-item {
  width: 300px;
  height: 100%;
  border: 1px solid gray;
  border-radius: 10px;
}
</style>
