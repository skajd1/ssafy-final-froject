<script setup>
import { watch, ref } from "vue";
import { getTripInfoById } from "@/api/TripApi";
import { storeToRefs } from "pinia";
import { useTripStore } from "@/stores/tripStore";
const tstore = useTripStore();
const { select } = tstore;
const { items: storeTripItems } = storeToRefs(tstore);

const props = defineProps({
  planItem: Object,
  index: Number,
});
// const plan = ref({});
const title = ref("");
const imgsrc = ref("");
let tripInfo = {};
function selectTrip() {
  select(tripInfo);
}
setTimeout(() => {
  storeTripItems.value.forEach((item) => {
    if (item.contentId == props.planItem.content_id) {
      tripInfo = item;
      title.value = item.title;
      imgsrc.value = item.firstImage;
    }
  });
}, 500);
</script>

<template>
  <div class="timeline-item">
    {{ planItem.date.split(" ")[0] }}
    {{ title }}
    <img v-if="imgsrc" :src="imgsrc" @click="selectTrip" />
    <img v-else src="@/assets/logo0.svg" @click="selectTrip" />

    {{ planItem.comment }}
  </div>
</template>

<style scoped>
.timeline-item {
  margin: 10px;
  min-width: 320px;
  max-width: 320px;

  border-radius: 10px;
}
.timeline-item img {
  width: 100%;
  height: 180px;
  border-radius: 10px;
}
</style>
