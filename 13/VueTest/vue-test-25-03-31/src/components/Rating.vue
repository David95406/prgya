<template>
  <div class="rating-container">
    <div class="stars">
      <span 
        v-for="index in maxRating" 
        :key="index" 
        class="star"
        :class="{ 'active': index <= rating }"
        @click="setRating(index)"
      >
        ★
      </span>
    </div>
    <div class="rating-text" v-if="showRatingText">
      Értékelés: {{ rating }} / {{ maxRating }}
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const props = defineProps({
  maxRating: {
    type: Number,
    default: 5
  },
  initialRating: {
    type: Number,
    default: 0
  },
  showRatingText: {
    type: Boolean,
    default: true
  }
});

const emit = defineEmits(['update:rating']);

const rating = ref(props.initialRating);

const setRating = (value) => {
  rating.value = value;
  emit('update:rating', value);
};
</script>

<style scoped>
.rating-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 15px 0;
}

.stars {
  display: flex;
  gap: 5px;
}

.star {
  font-size: 28px;
  cursor: pointer;
  color: #ddd;
  transition: color 0.2s ease;
}

.star:hover {
  color: #ffd700;
}

.star.active {
  color: #ffd700;
}

.rating-text {
  margin-top: 5px;
  font-size: 14px;
  color: #666;
}
</style>