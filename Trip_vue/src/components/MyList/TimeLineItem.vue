<script setup>
import { watch, ref } from "vue";
import { getTripInfoById } from "@/api/TripApi";
import { storeToRefs } from "pinia";
import { useTripStore } from "@/stores/tripStore";
const tstore = useTripStore();
const { tripItems: tripItems } = storeToRefs(tstore);

const props = defineProps({
  planItem: Object,
});
const plan = ref({});
const title = ref("");
const imgsrc = ref("");
const tmp = [];

getTripInfoById(
  props.planItem.content_id,
  (res) => {
    plan.value = res.data;
    title.value = plan.value[0].title;
    imgsrc.value = plan.value[0].firstImage;
    // tripItems.value.push(plan.value[0]);
    tmp.push(props.planItem.content_id);
  },
  (err) => {
    console.log(err);
  }
);
</script>

<template>
  <div class="timeline-item">
    {{ planItem.date.split(" ")[0] }}
    {{ title }}
    <img :src="imgsrc" />
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
