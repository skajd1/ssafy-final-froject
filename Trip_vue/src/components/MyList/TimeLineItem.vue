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
    <p>{{ planItem.date.split(" ")[0] }}</p>
    <p style="font-weight: bold">{{ title }}</p>

    <img v-if="imgsrc" :src="imgsrc" @click="selectTrip" />
    <img v-else src="@/assets/logo0.svg" @click="selectTrip" />

    <div class="memo-cost">
      <p>{{ planItem.comment }}</p>
      <p>{{ planItem.cost }}원</p>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.timeline-item {
  margin: 10px;
  min-width: 320px;
  max-width: 320px;

  p {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
}
.timeline-item img {
  width: 100%;
  height: 180px;
  border-radius: 10px;
}

.memo-cost {
  display: flex;
  justify-content: space-between;
  margin-top: 5px;
}
</style>
