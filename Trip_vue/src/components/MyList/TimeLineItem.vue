<script setup>
import { watchEffect, ref } from "vue";
import { getTripInfoById } from "@/api/TripApi";

const props = defineProps({
  item: Object,
});
const planItem = ref({});
const title = ref("");
const imgsrc = ref("");
getTripInfoById(
  props.item.content_id,
  (res) => {
    planItem.value = res.data;
    title.value = planItem.value[0].title;
    imgsrc.value = planItem.value[0].firstImage;
    console.log(planItem.value[0]);
  },
  (err) => {
    console.log(err);
  }
);
</script>

<template>
  <div class="timeline-item">
    {{ item.date.split(" ")[0] }}
    {{ title }}
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
.timeline-item img {
  width: 100%;

  border-radius: 10px;
}
</style>
